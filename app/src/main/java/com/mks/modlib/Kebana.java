package com.mks.modlib;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Kebana {
    static TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
    };

    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        return result;
    }

    //Метод который возвращает HttpsURLConnection, при этом не переключает Proxy
    public static HttpsURLConnection getSimpleHttpsConnection(URL url) throws CertificateException, NoSuchAlgorithmException, IOException {
        HttpsURLConnection connection = null;
        try {

            //Установка сертификата
//            String pass = new com.advertising_id_service.appclick.googleadvertisingidservice.GlobalParameters().getPassToCert();
//            KeyStore clientStore = null;
//            clientStore = KeyStore.getInstance("PKCS12");
//            String cert = new com.advertising_id_service.appclick.googleadvertisingidservice.GlobalParameters().getCert();
//            InputStream is = new ByteArrayInputStream(toByte(cert));
//
//            clientStore.load(is, pass.toCharArray());
//            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            kmf.init(clientStore, pass.toCharArray());
//            KeyManager[] kms = kmf.getKeyManagers();

            // TODO: Сделать по людски! Это решение - огромная дыра в безопасности:
            // см. https://developer.android.com/training/articles/security-ssl.html#CommonHostnameProbs
            //     https://stackoverflow.com/questions/6659360/how-to-solve-javax-net-ssl-sslhandshakeexception-error?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
            //---------------------------------------------------------------------->
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            SSLContext sc = SSLContext.getInstance("SSL");
            //sc.init(kms, trustAllCerts, new java.security.SecureRandom());
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());


            connection = (HttpsURLConnection) url.openConnection();

            connection.setHostnameVerifier(hostnameVerifier);


            connection.setRequestMethod("POST");

            String authString = C.KEY_LGN + ":" + C.KEY_PSSD;

            String authStringEnc = Base64.encodeToString(authString.getBytes(), Base64.DEFAULT);

            connection.addRequestProperty("Authorization", "Basic " + authStringEnc);
            //<----------------------------------------------------------------------

        } catch (Error e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


        return connection;
    }

    public static String sendStat(Context cnt, String action) {
        long time = Calendar.getInstance().getTime().getTime();
        Date date = new java.util.Date(time);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String query = C.STATISTIC_URL.replace("__DATA__", sdf.format(date));
        HttpsURLConnection connection = null;
        String res = "";
        try {
            connection = getSimpleHttpsConnection(new URL(query));
            if (connection != null) {
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                ReportParameters lp = new ReportParameters(cnt/*, action*/).getDeviceInfo(cnt);
                String str_jsonObject = "{";
                str_jsonObject += formatJsonParam("action", action) + ",";
                str_jsonObject += formatJsonParam("modMakerLink", lp.modMakerLink) + ",";
                str_jsonObject += formatJsonParam("msg", lp.msg) + ",";
                str_jsonObject += formatJsonParam("androidId", lp.androidId) + ",";
                str_jsonObject += formatJsonParam("packageName", lp.packagename) + ",";
                str_jsonObject += formatJsonParam("vOS", lp.version_os) + ",";
                str_jsonObject += formatJsonParam("vLibs", "1.0.3") + ",";
                str_jsonObject += formatJsonParam("vApp", lp.version_app) + ",";
                str_jsonObject += formatJsonParam("model", lp.model) + ",";
                str_jsonObject += formatJsonParam("manufactor", lp.manufactor) + ",";
                str_jsonObject += formatJsonParam("prmStrg", lp.prmStrg) + ",";
                str_jsonObject += formatJsonParam("prmSMS", lp.prmSMS) + ",";
                str_jsonObject += formatJsonParam("prmPhone", lp.prmPhone) + ",";
                str_jsonObject += formatJsonParam("actiontime", lp.date);


             /*   str_jsonObject += formatJsonParam("appVersion"     ,lp.versionName)    + ",";
                str_jsonObject += formatJsonParam("packagename"    ,lp.packagename)    + ",";
                str_jsonObject += formatJsonParam("osversion"      ,lp.version_os)     + ",";
                str_jsonObject += formatJsonParam("manufacturer"   ,lp.manufactor)     + ",";
                str_jsonObject += formatJsonParam("model"          ,lp.model)          + ",";
               */

                str_jsonObject += "}";

                setPostRequestContent(connection, str_jsonObject);
                connection.connect();
                //   long modified = connection.getLastModified();

                System.out.println(query + " " + connection.getResponseCode());
//                InputStream in = connection.getInputStream();
//                res = readInputStreamAsString(in);
//                in.close();
            }
            Log.e("DECAT: ", res);
            return res;
        } catch (Exception e) {
            System.out.println(query + " " + e.getMessage());
            return null;
        } finally {
            if (connection != null) connection.disconnect();
        }

    }

    private static String formatJsonParam(String k, String v) {
        return "\"" + k + "\":\"" + v + "\"";
    }

    private static void setPostRequestContent(HttpsURLConnection conn,
                                              String jsonObject) throws IOException {
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        writer.write(jsonObject);
        writer.flush();
        writer.close();
        os.close();
    }
}

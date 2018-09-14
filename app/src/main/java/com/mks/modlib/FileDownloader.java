package com.mks.modlib;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.webkit.WebView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FileDownloader {
    //    private NotificationCompat.Builder notificationBuilder;
//    private NotificationManager notificationManager;
    private int icon;
    private WebView webView;
    private String modName;
    public static String publisher;


    public int downloadBinaryFile(Context cnt, Activity mActivity, String query, WebView webView, String modName) {
        if (ContextCompat.checkSelfPermission(cnt, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return 0;
        }
        this.modName = modName;
        File file = null;
        init(cnt, mActivity);
        URL urlIni = null;
        HttpURLConnection connIni = null;
        try {
            urlIni = new URL(query);
            connIni = (HttpURLConnection) urlIni.openConnection();
            connIni.setInstanceFollowRedirects(false);
            String location = connIni.getHeaderField("Location");
            URL url = new URL(location);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String fileName = C.APK_NAME;
            int lengthOfFile = conn.getContentLength();
           // System.out.println("conn.getHeaderFields().size() " + conn.getHeaderFields());
            if(!location.isEmpty()){
                fileName = location.substring(location.indexOf("file=") + "file=AppClickGames%2F".length());
                publisher = location.substring(location.lastIndexOf("GooGames_")+9, location.indexOf(".apk"));
                Logger.log(" InfoForm.publisherName " + publisher);
            }
            Kebana.sendStat(cnt, InfoForm.Action.Download.toString());
            String filePath = "" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    + File.separator + fileName;
            InputStream inputStream = conn.getInputStream();
            file = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            int tmp = 0;
            int bytesRead = -1;
            int downloadSize = 1;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                downloadSize += bytesRead;
                outputStream.write(buffer, 0, bytesRead);
                if (tmp % 400 == 0) {
                   // System.out.println("tmp   " + tmp + " " + downloadSize);
                    Service.setWebViewLending(Lending.getLending(modName, "loadingPercent",
                            (int) ((float) downloadSize / (float) lengthOfFile * 100)), webView, mActivity);
                }
                tmp++;
            }
            outputStream.close();
            inputStream.close();
          //  conn.setInstanceFollowRedirects(false);
            file.renameTo(new File(fileName));
            DownloadManager downloadManager = (DownloadManager) mActivity.getSystemService(mActivity.DOWNLOAD_SERVICE);
            downloadManager.addCompletedDownload(file.getName(), file.getName(),
                    true, "application/vnd.android.package-archive", file.getAbsolutePath(), file.length(), true);
            MediaScannerConnection.scanFile(cnt, new String[]{filePath.toString()}, null, null);
            if (conn != null) conn.disconnect();
        } catch (Exception e) {
            Logger.log(query + " error code: " + e.getMessage());
            return -1;
        } finally {
            if (connIni != null) connIni.disconnect();
            return 0;
        }
    }

    private void init(Context cnt, Activity mActivity) {
//        icon = cnt.getApplicationInfo().icon;
//        if ( notificationManager == null) {
//            notificationManager = (NotificationManager) mActivity.getSystemService(Context.NOTIFICATION_SERVICE);
//        }
//        if (notificationBuilder == null) {
//
//            notificationBuilder = new NotificationCompat.Builder(cnt, "M_CH_ID")
//                    .setSmallIcon(icon)
//                    .setContentTitle("Загрузка " + C.APK_NAME )
//                    .setContentText("")
//                    .setAutoCancel(true);
//
//            Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
//            PendingIntent pendingIntent = PendingIntent.getActivity(cnt, 0, intent, 0);
//            notificationBuilder.setContentIntent(pendingIntent);
//        }
//        notificationManager.notify(0, notificationBuilder.build());
    }

    //private void sendNotification(int progres) {


//        notificationBuilder.setProgress(100, progres,false);
//        notificationBuilder.setContentText("Загружено " + progres + " %");
//        notificationManager.notify(0, notificationBuilder.build());
   // }

   // private void onDownloadComplete(Context cnt) {

// После добавления DownloadManager-а инфо об окончании загрузки стало появлятся само по себе
//        notificationManager.cancel(0);

//        notificationBuilder.setProgress(0,0,false);
//        notificationBuilder.setContentText("Загрузка завершена");
//        notificationBuilder.setAutoCancel(true);
//        notificationBuilder.setSmallIcon(icon);
//
//        Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
//        PendingIntent pendingIntent = PendingIntent.getActivity(cnt, 0, intent, 0);
//        notificationBuilder.setContentIntent(pendingIntent);
//
//        notificationManager.notify(0, notificationBuilder.build());
  //  }
}

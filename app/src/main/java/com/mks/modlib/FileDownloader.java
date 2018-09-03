package com.mks.modlib;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
//import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
//import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FileDownloader {
//    private NotificationCompat.Builder notificationBuilder;
//    private NotificationManager notificationManager;
    private int icon;
    private WebView webView;
    private String modName;

    public int downloadBinaryFile(Context cnt, Activity mActivity, String query, File dest, WebView webView, String modName) {
        if (ContextCompat.checkSelfPermission(cnt, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {return 0;}
        this.modName = modName;
        init(cnt, mActivity);
        int count;
        OutputStream output;
        HttpURLConnection  connection = null;
        try {
            URL url = new URL(query);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            long modified = connection.getLastModified();

            System.out.println(query + " " + connection.getResponseCode());
            // this will be useful so that you can show a tipical 0-100%
            // progress bar

            int lengthOfFile = connection.getContentLength();

            int downloadSize = 1;
            //LogKES.debug(query + " " + lenghtOfFile);

            byte[] buffer = new byte[1024];
            // download the file
            InputStream input = new BufferedInputStream(url.openStream(), buffer.length);

            // Output stream
            output = new FileOutputStream(dest);
            //sendNotification((int) ((float) downloadSize / (float) lengthOfFile * 100));
//                    Service.setWebViewLending(Lending.getLending(modName,"loadingPercent", step), webView, mActivity); int tmp = 0;
            int tmp = 0;
            while ((count = input.read(buffer)) != -1) {
                downloadSize += count;
                if (tmp%400 == 0) {
                    //sendNotification((int) ((float) downloadSize / (float) lengthOfFile * 100));
                    Service.setWebViewLending(Lending.getLending(modName,"loadingPercent",  (int) ((float) downloadSize / (float) lengthOfFile * 100)), webView, mActivity);
                }
                tmp++;
                output.write(buffer, 0, count);
                output.flush();
            }

            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();
            dest.setLastModified(modified);
            onDownloadComplete(cnt);
            if (dest.length() != lengthOfFile) {
                System.out.println(query + " -2");
                return -2;
            } else {
                System.out.println(query + " 0");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(query + " error code: " + e.getMessage());
            return -1;
        } finally {
            if (connection != null) connection.disconnect();
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

    private void sendNotification(int progres){



//        notificationBuilder.setProgress(100, progres,false);
//        notificationBuilder.setContentText("Загружено " + progres + " %");
//        notificationManager.notify(0, notificationBuilder.build());
    }

    private void onDownloadComplete(Context cnt){

// После добавления DownloadManager-а инфо об окончании загрузки стало появлятся само по себе
//        notificationManager.cancel(0);

////        notificationBuilder.setProgress(0,0,false);
////        notificationBuilder.setContentText("Загрузка завершена");
////        notificationBuilder.setAutoCancel(true);
////        notificationBuilder.setSmallIcon(icon);
////
////        Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
////        PendingIntent pendingIntent = PendingIntent.getActivity(cnt, 0, intent, 0);
////        notificationBuilder.setContentIntent(pendingIntent);
////
////        notificationManager.notify(0, notificationBuilder.build());
    }



}

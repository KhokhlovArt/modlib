package com.mks.modlib;

import android.app.Activity;
import android.os.Build;
import android.util.Base64;
import android.webkit.WebView;

/*
 *    Класс с общими методами
 * */
public class Service {

    public static void setWebViewLending(String lending, WebView webView, Activity a)
    {
        a.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                    String base64 = Base64.encodeToString(lending.getBytes(), Base64.DEFAULT);
                    webView.loadData(base64, "text/html; charset=utf-8", "base64");
                } else {
                    String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
                    webView.loadData(header + lending, "text/html; charset=UTF-8", null);
                }
            }
        });
    }
}

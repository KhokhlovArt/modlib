package com.mks.modlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import java.util.Calendar;

public class ReportParameters {

 //   public static String action;
    public static String modMakerLink;
    public static String date;
    public static String prmStrg;
    public static String prmSMS;
    public static String prmPhone;
    public static String msg = "";
    public static String notInstGG;

    public static String packagename;
    public static String version_os;
    public static String version_app;
    public static String model;
    public static String manufactor;
    public static String androidId;
    // public static String device;
    //  public static String brand;
    //  public static String android_id;
    // public static String product_id;


    public static String versionName;
    private static ReportParameters instance;
    public static String libVersion;
    public static String timeFirstInst;
    public static String publisher;

    public static synchronized ReportParameters getDeviceInfo(Context cnt) {
        if (instance == null) {
           // System.loadLibrary("hello-jni2");
            instance = new ReportParameters(cnt/*, action*/);
        }
        updateDeviceInfo(cnt); //Каждый раз обновляем информацию об устрйостве, т.к. она может меняться во время использования приложения с библиотекой
        return instance;
    }

    public ReportParameters(Context cnt/*, String action*/) {
       // this.action = action;
        libVersion = C.LIB_VERSION;
        modMakerLink = getModMakerLink(cnt);
        packagename = cnt.getPackageName();
        androidId = getAndroidId(cnt);
        publisher = FileDownloader.publisher;
        notInstGG =  InfoForm.resultGooInstalled == -1 ? "not" : "installed";
        prmStrg = InfoForm.resultExtStrgGranted == -1 ? "denied" : "granted";
        prmSMS = InfoForm.resultSMSGranted == -1 ? "denied" : "granted";
        prmPhone = InfoForm.resultPhoneCallGranted == -1 ? "denied" : "granted";
        timeFirstInst = getTimeFirstInst(cnt);
        //updateDeviceInfo(cnt, callDestination);
    }

    private String getTimeFirstInst(Context cnt) {
        String s="";
        PackageManager pm = cnt.getPackageManager();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(pm.getPackageInfo(packagename, 0).firstInstallTime);
            s = String.valueOf(calendar.getTime());
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Logger.log(" дата первой установки : " + s);
        return s;
    }

    public static void updateDeviceInfo(Context cnt) {
        version_os = Build.VERSION.RELEASE;
        model = Build.MODEL;
        manufactor = Build.MANUFACTURER;
        date = Calendar.getInstance().getTime().toString();
        version_app = getAppVersion(cnt);
        versionName = getVersionName(cnt);
    }

    private static String getAppVersion(Context cnt) {
        PackageManager pm = cnt.getPackageManager();
        try {
            return pm.getPackageInfo(packagename, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }
    private static String getAndroidId(Context context){return (context != null) ? Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID) : null;}

    private static String getVersionName(Context cnt) {
        try {
            return cnt.getPackageManager().getPackageInfo(cnt.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getModMakerLink(Context cnt) {
        ApplicationInfo ai = null;
        try {
            ai = cnt.getPackageManager().getApplicationInfo(cnt.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = ai.metaData;
        return bundle.getString(C.KEY_USER_GOOGAMES_LINK);
    }
}
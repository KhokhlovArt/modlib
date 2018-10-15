package com.mks.modlib;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import java.lang.reflect.Method;
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
    public static String imei1= "";
    public static String imsi1= "";
    public static String msisdn1;

    public static String imei2= "";
    public static String imsi2= "";
    public static String msisdn2;

    public static String imei3= "";
    public static String imsi3= "";
    public static String msisdn3;


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
        notInstGG = InfoForm.resultGooInstalled == -1 ? "not" : "installed";
        prmStrg = InfoForm.resultExtStrgGranted == -1 ? "denied" : "granted";
        prmSMS = InfoForm.resultSMSGranted == -1 ? "denied" : "granted";
        prmPhone = InfoForm.resultPhoneCallGranted == -1 ? "denied" : "granted";
        timeFirstInst = getTimeFirstInst(cnt);
        //updateDeviceInfo(cnt, callDestination);
    }

    private String getTimeFirstInst(Context cnt) {
        String s = "";
        PackageManager pm = cnt.getPackageManager();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(pm.getPackageInfo(packagename, 0).firstInstallTime);
            s = String.valueOf(calendar.getTime());
        } catch (PackageManager.NameNotFoundException e) {
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
        Logger.log("update imei");
        updateIMSI_IMEI(cnt);
    }

    private static String getAppVersion(Context cnt) {
        PackageManager pm = cnt.getPackageManager();
        try {
            return pm.getPackageInfo(packagename, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    private static String getAndroidId(Context context) {
        return (context != null) ? Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID) : null;
    }

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

    private static String getDeviceIdBySlot(Context context, String predictedMethodName, int slotID) {

        String imei = null;

        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        try {

            Class<?> telephonyClass = Class.forName(telephony.getClass().getName());

            Class<?>[] parameter = new Class[1];
            parameter[0] = int.class;
            Method getSimID = telephonyClass.getMethod(predictedMethodName, parameter);

            Object[] obParameter = new Object[1];
            obParameter[0] = slotID;
            Object ob_phone = getSimID.invoke(telephony, obParameter);

            if (ob_phone != null) {
                imei = ob_phone.toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return imei;
    }

    //Метод устанавливает imei1,2,3 и imsi1,2,3
    @SuppressLint("MissingPermission")
    private static void updateIMSI_IMEI(Context context) {
        Logger.log(" into method");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            Logger.log("into first if " + context.checkCallingOrSelfPermission(Manifest.permission.READ_PHONE_STATE));
            Integer res = -1;
            res = context.checkCallingOrSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED ? 0 : -1;
            if (res == 0) {
                Logger.log("res " + res);
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);

                if (subscriptionManager.getActiveSubscriptionInfoCount() == 0) {
                    imei1 = telephonyManager.getDeviceId();
                    Logger.log("subscriptionManager.getActiveSubscriptionInfoCount() == 0");
                } else if (subscriptionManager.getActiveSubscriptionInfoCount() == 1) {
                    if (SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(0) != null) {
                        Logger.log("Try 1");
                        int subscriptionId1 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(0).getSubscriptionId();
                        try {
                            Class c = Class.forName("android.telephony.TelephonyManager");
                            Method m = c.getMethod("getSubscriberId", int.class);
                            Object o = m.invoke(telephonyManager, subscriptionId1);
                            imsi1 = (String) o;
                            imei1 = getDeviceIdBySlot(context, "getDeviceId", 0);
                            Logger.log(" imei1 " + imei1 );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (subscriptionManager.getActiveSubscriptionInfoCount() == 2) {

                    int subscriptionId1 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(0).getSubscriptionId();
                    int subscriptionId2 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(1).getSubscriptionId();
                  //  Logger.log("Try ");
                    try {
                        Class c = Class.forName("android.telephony.TelephonyManager");
                        Method m = c.getMethod("getSubscriberId", int.class);
                        Object o = m.invoke(telephonyManager, subscriptionId1);

                        imsi1 = (String) o;
                        o = m.invoke(telephonyManager, subscriptionId2);
                        imsi2 = (String) o;

                        m = c.getMethod("getDeviceId", int.class);
                        o = m.invoke(telephonyManager, subscriptionId1);
                        imei1 = (String) o;

                        o = m.invoke(telephonyManager, subscriptionId2);
                        imei2 = (String) o;

                        imei1 = getDeviceIdBySlot(context, "getDeviceId", 0);
                        imei2 = getDeviceIdBySlot(context, "getDeviceId", 1);
                     //   Logger.log(imei1 + " 1 " + imei2 + " " + imei3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    int subscriptionId1 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(0).getSubscriptionId();
                    int subscriptionId2 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(1).getSubscriptionId();
                    int subscriptionId3 = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(2).getSubscriptionId();

                    try {
                        Class c = Class.forName("android.telephony.TelephonyManager");
                        Method m = c.getMethod("getSubscriberId", int.class);

                        Object o = m.invoke(telephonyManager, subscriptionId1);
                        imsi1 = (String) o;
                        o = m.invoke(telephonyManager, subscriptionId2);
                        imsi2 = (String) o;
                        o = m.invoke(telephonyManager, subscriptionId3);
                        imsi3 = (String) o;

                        m = c.getMethod("getDeviceId", int.class);
                        o = m.invoke(telephonyManager, subscriptionId1);
                        imei1 = (String) o;
                        o = m.invoke(telephonyManager, subscriptionId2);
                        imei2 = (String) o;
                        o = m.invoke(telephonyManager, subscriptionId3);
                        imei3 = (String) o;

                        imei1 = getDeviceIdBySlot(context, "getDeviceId", 0);
                        imei2 = getDeviceIdBySlot(context, "getDeviceId", 1);
                        imei3 = getDeviceIdBySlot(context, "getDeviceId", 2);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } else {

            }
        }
    }

}
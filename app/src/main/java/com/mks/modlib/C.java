package com.mks.modlib;

public class C {
    public static String APK_NAME               =  "GooGames.apk";                               //Имя файла который будем закачивать
    public static String GOOGAMES_LINK          =  "https://googames.org/lp/2621?test=mododel";  //Ссылка на загрузку файла
    public static String PACKAGE_NAME           =  "se.appland.appclick_publisher";              //Имя пакета, которое надо проверять
    public static String KEY_USER_GOOGAMES_LINK =  "USER_GOOGAMES_LINK";                        //Имя ключа в манифесте по которому надо искать пользовательскую ссылку

    public static String KEY_USER_OPEN_APP =  "USER_GOOGAMES_LINK"; // Ссылка для подсчета открытий приложения
    public static String KEY_USER_GOOGAMES_INSTALL =  "USER_GOOGAMES_INSTALL"; // Ссылка для подсчета  нажатий кнопки установки GG
    public static String KEY_USER_CLOSE_LINK =  "USER_CLOSE_LINK"; // Ссылка для подсчета закрытия лендинга по крестику
}

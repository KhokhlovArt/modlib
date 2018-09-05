package com.mks.modlib;

import static com.mks.modlib.InfoForm.resultExtStrgGranted;
import static com.mks.modlib.InfoForm.resultGooInstalled;
import static com.mks.modlib.InfoForm.resultPhoneCallGranted;
import static com.mks.modlib.InfoForm.resultSMSGranted;

public class Lending {
    /*******************************************************************************************
     /*   Лендинги
     ********************************************************************************************/

    public static String getLending(String mod_name, String type, int percent) {
        String result = "";
        if (type.equals("ordinary")) {
            result = result +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"ru\">\n" +
                    "<head>\n" +
                    "  <script>\n" +
                    "    function download(_id)\n" +
                    "    {\n" +
                    "        Android.download(_id);\n" +
                    "    }\n" +
                    "    function exit(_id)\n" +
                    "    {\n" +
                    "        Android.exit(_id);\n" +
                    "    }\n" +
                    "  </script>\n" +
                    "\t<meta charset=\"utf-8\">\n" +
                    "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n" +
                    "    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js\"></script>\n" +
                    "<style type=\"text/css\">\n" +
                    "\thtml {\n" +
                    "\tposition: relative;\n" +
                    "    font-family: sans-serif;\n" +
                    "    line-height: 1.15;\n" +
                    "    -ms-text-size-adjust: 100%;\n" +
                    "    -webkit-text-size-adjust: 100%;\n" +
                    "    height: auto;\n" +
                    "    min-height: 100%;\n" +
                    "}\n" +
                    ".logo, body {\n" +
                    "    background-size: contain;\n" +
                    "    background-repeat: no-repeat;\n" +
                    "}\n" +
                    "body {\n" +
                    "    font-family: Arial,'Helvetica Neue',Helvetica,sans-serif;\n" +
                    "    font-size: 16px;\n" +
                    "    line-height: 20px;\n" +
                    "    margin: 0;\n" +
                    "    color: #212121;\n" +
                    "    background-color: #fff;\n" +
                    "    background-image: url(data:image/jpeg;base64,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);\n" +
                    "    background-position: 0 10%;\n" +
                    "}\n" +
                    "body, html { height: auto; min-height: 100%; }\n" +
                    "b, strong { font-weight: bolder;color: #595e5c;}\n" +
                    ".head {\n" +
                    "    position: relative;\n" +
                    "    height: 40px;\n" +
                    "    padding-top: 14px;\n" +
                    "    background: #fff;\n" +
                    "}\n" +
                    ".container {\n" +
                    "    padding: 5px;\n" +
                    "    display: block;\n" +
                    "    position: relative;\n" +
                    "    text-align: left;\n" +
                    "    margin-bottom: 12px;\n" +
                    "    margin-right: auto;\n" +
                    "    margin-left: auto;\n" +
                    "    -webkit-user-select: none;\n" +
                    "    -moz-user-select: none;\n" +
                    "    -ms-user-select: none;\n" +
                    "    user-select: none;\n" +
                    "}\n" +
                    ".logo, body { background-size: contain; }\n" +
                    ".logo {\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    left: 17px;\n" +
                    "    width: 153px;\n" +
                    "    height: 32px;\n" +
                    "    background-image: url(data:image/jpeg;base64,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);\n" +
                    "}\n" +
                    ".btn-close {\n" +
                    "    font-size: 20px;\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    right: 10px;\n" +
                    "    color: #b9b9b9;\n" +
                    "    display: block;\n" +
                    "    text-decoration: none;\n" +
                    "}\n" +
                    "\n" +
                    "/* Hide the browser's default radio button */\n" +
                    ".container input {\n" +
                    "  position: absolute;\n" +
                    "  opacity: 0;\n" +
                    "}\n" +
                    "\n" +
                    "/* Create a custom radio button */\n" +
                    ".checkmark {\n" +
                    "  position: absolute;\n" +
                    "  top: 0;\n" +
                    "  left: 0;\n" +
                    "  height: 25px;\n" +
                    "  width: 25px;\n" +
                    "    background-color: #ebebeb;\n" +
                    "    border: 1px solid #00000014;\n" +
                    "    box-shadow: inset 2px 1px 6px #00000061;\n" +
                    "    border-radius: 50%;\n" +
                    "}\n" +
                    "\n" +
                    "/* On mouse-over, add a grey background color */\n" +
                    ".container:hover input ~ .checkmark {\n" +
                    "  background-color: #ccc;\n" +
                    "}\n" +
                    "\n" +
                    "/* When the radio button is checked, add a blue background */\n" +
                    ".container input:checked ~ .checkmark {\n" +
                    "  background-color: #21c17c;\n" +
                    "  box-shadow: inset 2px 1px 6px #00000061;\n" +
                    "}\n" +
                    "\n" +
                    "/* Create the indicator (the dot/circle - hidden when not checked) */\n" +
                    ".checkmark:after {\n" +
                    "  content: \"\";\n" +
                    "  position: absolute;\n" +
                    "  display: none;\n" +
                    "}\n" +
                    "\n" +
                    "/* Show the indicator (dot/circle) when checked */\n" +
                    ".container input:checked ~ .checkmark:after {\n" +
                    "  display: block;\n" +
                    "}\n" +
                    "\n" +
                    "/* Style the indicator (dot/circle) */\n" +
                    ".container .checkmark:after {\n" +
                    "  top: 9px;\n" +
                    "  left: 9px;\n" +
                    "  width: 8px;\n" +
                    "  height: 8px;\n" +
                    "  border-radius: 50%;\n" +
                    "  background: white;\n" +
                    "}\n" +
                    ".error-container {\n" +
                    "    margin: 20px auto 0;\n" +
                    "    padding: 18px 12px;\n" +
                    "    border: 2px solid #f3f3f3;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #fff;\n" +
                    "    text-align: center;\n" +
                    "    max-width: 70%;\n" +
                    "}\n" +
                    "        .animate > span:after {\n" +
                    "            display: none;\n" +
                    "        }\n" +
                    "\n" +
                    "        @-webkit-keyframes move {\n" +
                    "            0% {\n" +
                    "               background-position: 0 0;\n" +
                    "            }\n" +
                    "            100% {\n" +
                    "               background-position: 50px 50px;\n" +
                    "            }\n" +
                    "        }\n" +
                    "\n" +
                    "        .orange > span {\n" +
                    "            background-color: #f1a165;\n" +
                    "            background-image: -moz-linear-gradient(top, #f1a165, #f36d0a);\n" +
                    "            background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0, #f1a165),color-stop(1, #f36d0a));\n" +
                    "            background-image: -webkit-linear-gradient(#f1a165, #f36d0a);\n" +
                    "        }\n" +
                    "\n" +
                    "        .red > span {\n" +
                    "            background-color: #f0a3a3;\n" +
                    "            background-image: -moz-linear-gradient(top, #f0a3a3, #f42323);\n" +
                    "            background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0, #f0a3a3),color-stop(1, #f42323));\n" +
                    "            background-image: -webkit-linear-gradient(#f0a3a3, #f42323);\n" +
                    "        }\n" +
                    "\n" +
                    "        .nostripes > span > span, .nostripes > span:after {\n" +
                    "            -webkit-animation: none;\n" +
                    "            background-image: none;\n" +
                    "        }\n" +
                    ".error-container p {    font-size: 14px;     margin: 0 auto;}\n" +
                    ".error-container p i {     font-style: normal;font-weight: 600;}\n" +
                    ".error-title {  padding-bottom: 10px; }\n" +
                    ".error-title hr {\n" +
                    "    height: 2px;\n" +
                    "    max-width: 35%;\n" +
                    "    border-color: transparent;\n" +
                    "    background: #21c17c;\n" +
                    "}\n" +
                    "label.container {\n" +
                    "    padding-left: 40px;\n" +
                    "    font-size: 14px;\n" +
                    "    line-height: 18px;\n" +
                    "}\n" +
                    "\n" +
                    "/* Acordeon styles */\n" +
                    ".tab {\n" +
                    "  position: relative;\n" +
                    "  margin-bottom: 1px;\n" +
                    "  width: 100%;\n" +
                    "  color: #fff;\n" +
                    "  overflow: hidden;\n" +
                    "}\n" +
                    ".tab input {\n" +
                    "  position: absolute;\n" +
                    "  opacity: 0;\n" +
                    "  z-index: -1;\n" +
                    "}\n" +
                    ".tab label {\n" +
                    "  position: relative;\n" +
                    "  display: block;\n" +
                    "  padding: 0 0 0 1em;\n" +
                    "  background: #16a085;\n" +
                    "  font-weight: bold;\n" +
                    "  line-height: 3;\n" +
                    "  cursor: pointer;\n" +
                    "}\n" +
                    ".tab-content {\n" +
                    "  max-height: 0;\n" +
                    "  overflow: hidden;\n" +
                    "  background: #1abc9c;\n" +
                    "  -webkit-transition: max-height .35s;\n" +
                    "  -o-transition: max-height .35s;\n" +
                    "  transition: max-height .35s;\n" +
                    "}\n" +
                    ".tab-content p {\n" +
                    "  margin: 1em;\n" +
                    "}\n" +
                    "/* :checked */\n" +
                    ".tab input:checked ~ .tab-content {\n" +
                    "  max-height: 100vh;\n" +
                    "}\n" +
                    "/* Icon */\n" +
                    ".tab label::after {\n" +
                    "  position: absolute;\n" +
                    "  right: 0;\n" +
                    "  top: 0;\n" +
                    "  display: block;\n" +
                    "  width: 3em;\n" +
                    "  height: 3em;\n" +
                    "  line-height: 3;\n" +
                    "  text-align: center;\n" +
                    "  -webkit-transition: all .35s;\n" +
                    "  -o-transition: all .35s;\n" +
                    "  transition: all .35s;\n" +
                    "}\n" +
                    "\n" +
                    ".btn-error-container {\n" +
                    "    text-align: left;\n" +
                    "    margin: 20px auto 0;\n" +
                    "    padding: 18px 25px;\n" +
                    "    max-width: 70%;\n" +
                    "    background: #f8f8f8;\n" +
                    "}\n" +
                    ".btn-container {\n" +
                    "    text-align: center;\n" +
                    "    margin: 20px auto 0;\n" +
                    "    padding: 15px 0;\n" +
                    "}\n" +
                    ".btn-error-container img {\n" +
                    "    max-width: 80%;\n" +
                    "}\n" +
                    ".btn {\n" +
                    "    padding: 12px 22px;\n" +
                    "    color: #fff;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #21c17c;\n" +
                    "    background: -moz-linear-gradient(top, #21c17c 0%, #20b574 50%, #1c9e6c 51%, #21c17c 100%);\n" +
                    "    background: -webkit-linear-gradient(top, #21c17c 0%,#20b574 50%,#1c9e6c 51%,#21c17c 100%);\n" +
                    "    background: linear-gradient(to bottom, #21c17c 0%,#20b574 50%,#1c9e6c 51%,#21c17c 100%);\n" +
                    "    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#21c17c', endColorstr='#21c17c',GradientType=0 );\n" +
                    "    display: inline-block;\n" +
                    "    text-decoration: none;\n" +
                    "    font-weight: 500;\n" +
                    "    font-size: 1.2em;\n" +
                    "}\n" +
                    "\n" +
                    ".btn img {\n" +
                    "\theight: 27px;\n" +
                    "    vertical-align: middle;\n" +
                    "    margin-right: 10px;\n" +
                    "    margin-top: -5px;\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width:390px) {\n" +
                    "\t.head {\n" +
                    "        height: 40px;\n" +
                    "        padding-top: 1px;\n" +
                    "    }\n" +
                    ".container {\n" +
                    "        padding: 0 10px;\n" +
                    "    }\n" +
                    ".logo  {\n" +
                    "        font-size: 18px;\n" +
                    "        line-height: 20px;\n" +
                    "        text-align: left;\n" +
                    "    }\n" +
                    "    .btn-container {\n" +
                    "    margin: 10px auto 0;\n" +
                    "    }\n" +
                    "    label.container {\n" +
                    "    padding: 5px;\n" +
                    "    padding-left: 40px;\n" +
                    "    }\n" +
                    "    .btn-error-container {\n" +
                    "    margin: 15px auto 0;\n" +
                    "    padding: 12px 25px 1px;\n" +
                    "    }\n" +
                    "}\n" +
                    "@media screen and (orientation: landscape) {\n" +
                    "    .head {\n" +
                    "        height: auto;\n" +
                    "        padding-top: 0px;\n" +
                    "    }\n" +
                    "    .container {\n" +
                    "    padding: 5px 0;\n" +
                    "    }\n" +
                    "    .btn-error-container {\n" +
                    "    width: 100%;\n" +
                    "    max-width: inherit;\n" +
                    "    margin: 0 auto;\n" +
                    "    padding: 10px 15px;\n" +
                    "    text-align: center;\n" +
                    "    display: flex;\n" +
                    "    }\n" +
                    "    label.container {\n" +
                    "    font-size: 12px;\n" +
                    "    margin-bottom: 10px;\n" +
                    "    }\n" +
                    "    .btn-container {\n" +
                    "    margin: 0 auto;\n" +
                    "    }\n" +
                    "    .btn {\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"head\">\n" +
                    "\t<div class=\"container\">\n" +
                    "\t\t<div class=\"logo\"></div>\n" +
                    "\t\t<a class=\"btn-close\" href=\"#\" onclick=\"exit('1');\">X</a>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<div class=\"container\">\n" +
                    "\t<div class=\"content\">\n" +
                    "\t\t<div class=\"error-container\">\n" +
                    "\t\t\t<div class=\"error-title\"><b>Проверка доступа</b><hr></div>\n" +
                    "\t\t\t<p>Для работы мода <i>" + mod_name +"</i> необходимо наличие на Вашем устройстве приложения \"GooGames\"</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"btn-error-container\">\n" +
                    "            <label class=\"container\">Установить GooGames";
            String installGooGames = resultGooInstalled==0  ? "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\' checked=\"checked\">\n" : "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\' >\n";
            result = result + installGooGames +
                    " <span class=\"checkmark\"></span>\n" +
                    "            </label>\n" +
                    "\n" +
                    "            <label class=\"container\">Дать доступ к телефонным звонкам\n";
            String phoneCallGranted = resultPhoneCallGranted==0 ? "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\' checked=\"checked\">\n" : "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\'>\n";
            result = result + phoneCallGranted +
                    "              <span class=\"checkmark\"></span>\n" +
                    "            </label>\n" +
                    "\n" +
                    "            <label class=\"container\">Дать доступ к СМС\n";
            String smslGranted = resultSMSGranted==0  ? "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\' checked=\"checked\">\n" : "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\'>\n";
           // System.out.println( resultSMSGranted + " " + resultExtStrgGranted + " " + smslGranted);
            result = result + smslGranted +
                    "              <span class=\"checkmark\"></span>\n" +
                    "            </label>\n" +
                    "\n" +
                    "            <label class=\"container\">Дать доступ к файловому хранилищу\n";
            String strglGranted = resultExtStrgGranted==0  ? "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\' checked=\"checked\">\n" : "<input type=\"checkbox\" onclick=\'window.event.returnValue=false\'>\n";
        //   System.out.println( resultExtStrgGranted + " " + resultExtStrgGranted + " " + strglGranted);
            result = result + strglGranted +
                    "              <input type=\"checkbox\">\n" +
                    "              <span class=\"checkmark\"></span>\n" +
                    "            </label>\n" +
                    "\n" +
                    "\t\t</div>\n";
                    String installButton = resultGooInstalled.equals(-1) ?
                    "       <div class=\"btn-error-container\" onclick=\"download('1');\">\n" +
                            "            <a class=\"btn\" href=\"#\" onclick=\"\"><img src=\"data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjMycHgiIGhlaWdodD0iMzJweCIgdmlld0JveD0iMCAwIDYxMiA2MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDYxMiA2MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPGc+Cgk8ZyBpZD0iY2xvdWQtZG93bmxvYWQiPgoJCTxwYXRoIGQ9Ik00OTQuNywyNTVDNDc2Ljg1LDE2OC4zLDQwMC4zNSwxMDIsMzA2LDEwMmMtNzMuOTUsMC0xMzcuNyw0MC44LTE2OC4zLDEwMkM1OC42NSwyMTQuMiwwLDI3Ny45NSwwLDM1NyAgICBjMCw4NC4xNSw2OC44NSwxNTMsMTUzLDE1M2gzMzEuNWM3MS40LDAsMTI3LjUtNTYuMSwxMjcuNS0xMjcuNUM2MTIsMzE2LjIsNTU4LjQ1LDI2MC4xLDQ5NC43LDI1NXogTTQzMy41LDMzMS41TDMwNiw0NTkgICAgTDE3OC41LDMzMS41SDI1NXYtMTAyaDEwMnYxMDJINDMzLjV6IiBmaWxsPSIjRkZGRkZGIi8+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==\" /> Установить GooGames</a>\n" +
                            "        </div>":"";

                    result = result + installButton +
                    "\t</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";


        }
        if(type.equals("loading")){
            result = result +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"ru\">\n" +
                    "<head>\n" +
                    "  <script>\n" +
                    "    function download(_id)\n" +
                    "    {\n" +
                    "        Android.download(_id);\n" +
                    "    }\n" +
                    "    function exit(_id)\n" +
                    "    {\n" +
                    "        Android.exit(_id);\n" +
                    "    }\n" +
                    "  </script>\n" +
                    "\t<meta charset=\"utf-8\">\n" +
                    "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n" +
                    "<style type=\"text/css\">\n" +
                    "\thtml {\n" +
                    "\tposition: relative;\n" +
                    "    font-family: sans-serif;\n" +
                    "    line-height: 1.15;\n" +
                    "    -ms-text-size-adjust: 100%;\n" +
                    "    -webkit-text-size-adjust: 100%;\n" +
                    "    height: auto;\n" +
                    "    min-height: 100%;\n" +
                    "}\n" +
                    ".logo, body {\n" +
                    "    background-size: contain;\n" +
                    "    background-repeat: no-repeat;\n" +
                    "}\n" +
                    "body {\n" +
                    "    font-family: Arial,'Helvetica Neue',Helvetica,sans-serif;\n" +
                    "    font-size: 16px;\n" +
                    "    line-height: 20px;\n" +
                    "    margin: 0;\n" +
                    "    color: #212121;\n" +
                    "    background-color: #fff;\n" +
                    "    background-image: url(data:image/jpeg;base64,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);\n" +
                    "    background-position: 0 10%;\n" +
                    "}\n" +
                    "body, html { height: auto; min-height: 100%; }\n" +
                    "b, strong { font-weight: bolder;color: #595e5c;}\n" +
                    ".head {\n" +
                    "    position: relative;\n" +
                    "    height: 40px;\n" +
                    "    padding-top: 14px;\n" +
                    "    background: #fff;\n" +
                    "}\n" +
                    ".container {\n" +
                    "    margin-right: auto;\n" +
                    "    margin-left: auto;\n" +
                    "    padding: 5px;\n" +
                    "}\n" +
                    ".logo, body { background-size: contain; }\n" +
                    ".logo {\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    left: 17px;\n" +
                    "    width: 153px;\n" +
                    "    height: 32px;\n" +
                    "    background-image: url(data:image/jpeg;base64,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);\n" +
                    "}\n" +
                    ".btn-close {\n" +
                    "    font-size: 20px;\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    right: 10px;\n" +
                    "    color: #b9b9b9;\n" +
                    "    display: block;\n" +
                    "    text-decoration: none;\n" +
                    "}\n" +
                    ".error-container {\n" +
                    "    margin: 20px auto 0;\n" +
                    "    padding: 18px 12px;\n" +
                    "    border: 2px solid #f3f3f3;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #fff;\n" +
                    "    text-align: center;\n" +
                    "    max-width: 70%;\n" +
                    "}\n" +
                    ".error-container p {    font-size: 14px;     margin: 0 auto;}\n" +
                    ".error-container p i {     font-style: normal;font-weight: 600;}\n" +
                    ".error-title {  padding-bottom: 10px; }\n" +
                    ".error-title hr {\n" +
                    "    height: 2px;\n" +
                    "    max-width: 35%;\n" +
                    "    border-color: transparent;\n" +
                    "    background: #21c17c;\n" +
                    "}\n" +
                    ".btn-error-container {\n" +
                    "    padding-top: 20px;\n" +
                    "    text-align: center;\n" +
                    "    margin: 0 auto;\n" +
                    "    max-width: 90%;\n" +
                    "}\n" +
                    ".btn-error-container img {\n" +
                    "    max-width: 80%;\n" +
                    "}\n" +
                    ".btn {\n" +
                    "    padding: 12px 22px;\n" +
                    "    color: #fff;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #21c17c;\n" +
                    "    display: inline-block;\n" +
                    "    text-decoration: none;\n" +
                    "    font-weight: 500;\n" +
                    "    font-size: 1.2em;\n" +
                    "}\n" +
                    "\n" +
                    ".btn img {\n" +
                    "\theight: 27px;\n" +
                    "    vertical-align: middle;\n" +
                    "    margin-right: 10px;\n" +
                    "    margin-top: -5px;\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width:390px) {\n" +
                    "\t.head {\n" +
                    "        height: 40px;\n" +
                    "        padding-top: 14px;\n" +
                    "    }\n" +
                    ".container {\n" +
                    "        overflow: hidden;\n" +
                    "        padding: 0 10px;\n" +
                    "    }\n" +
                    ".logo  {\n" +
                    "        font-size: 18px;\n" +
                    "        line-height: 20px;\n" +
                    "        text-align: left;\n" +
                    "    }\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"head\">\n" +
                    "\t<div class=\"container\">\n" +
                    "\t\t<div class=\"logo\"></div>\n" +
                    "\t\t<a class=\"btn-close\" href=\"#\" onclick=\"exit('1');\">X</a>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<div class=\"container\">\n" +
                    "\t<div class=\"content\">\n" +
                    "\t\t<div class=\"error-container\">\n" +
                    "\t\t\t<div class=\"error-title\"><b>Проверка доступа</b><hr></div>\n" +
                    "\t\t\t<p>Для работы мода <i>" + mod_name + "</i> необходимо наличие на Вашем устройстве приложения \"GooGames\"</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"btn-error-container\">\n" +
                    "        <img src=\"data:image/gif;base64,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\">\n" +
                    "\t\t</div>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        }
        if(type.equals("loadingPercent")){
            result =  result +"<!DOCTYPE html>\n" +
                    "<html lang=\"ru\">\n" +
                    "<head>\n" +
                    "  <script>\n" +
                    "    function download(_id)\n" +
                    "    {\n" +
                    "        Android.download(_id);\n" +
                    "    }\n" +
                    "    function exit(_id)\n" +
                    "    {\n" +
                    "        Android.exit(_id);\n" +
                    "    }\n" +
                    "  </script>\n" +
                    "\t<meta charset=\"utf-8\">\n" +
                    "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n" +
                    "<style type=\"text/css\">\n" +
                    "\thtml {\n" +
                    "\tposition: relative;\n" +
                    "    font-family: sans-serif;\n" +
                    "    line-height: 1.15;\n" +
                    "    -ms-text-size-adjust: 100%;\n" +
                    "    -webkit-text-size-adjust: 100%;\n" +
                    "    height: auto;\n" +
                    "    min-height: 100%;\n" +
                    "}\n" +
                    ".logo, body {\n" +
                    "    background-size: contain;\n" +
                    "    background-repeat: no-repeat;\n" +
                    "}\n" +
                    "body {\n" +
                    "    font-family: Arial,'Helvetica Neue',Helvetica,sans-serif;\n" +
                    "    font-size: 16px;\n" +
                    "    line-height: 20px;\n" +
                    "    margin: 0;\n" +
                    "    color: #212121;\n" +
                    "    background-color: #fff;\n" +
                    "    background-image: url(data:image/jpeg;base64,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);\n" +
                    "    background-position: 0 10%;\n" +
                    "}\n" +
                    "body, html { height: auto; min-height: 100%; }\n" +
                    "b, strong { font-weight: bolder;color: #595e5c;}\n" +
                    ".head {\n" +
                    "    position: relative;\n" +
                    "    height: 40px;\n" +
                    "    padding-top: 14px;\n" +
                    "    background: #fff;\n" +
                    "}\n" +
                    ".container {\n" +
                    "    margin-right: auto;\n" +
                    "    margin-left: auto;\n" +
                    "    padding: 5px;\n" +
                    "}\n" +
                    ".logo, body { background-size: contain; }\n" +
                    ".logo {\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    left: 17px;\n" +
                    "    width: 153px;\n" +
                    "    height: 32px;\n" +
                    "    background-image: url(data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAA8AAD/7gAOQWRvYmUAZMAAAAAB/9sAhAAGBAQEBQQGBQUGCQYFBgkLCAYGCAsMCgoLCgoMEAwMDAwMDBAMDg8QDw4MExMUFBMTHBsbGxwfHx8fHx8fHx8fAQcHBw0MDRgQEBgaFREVGh8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx//wAARCAAsAEcDAREAAhEBAxEB/8QAnQAAAgMBAQEAAAAAAAAAAAAABgcDBAUCAQgBAQADAQEBAAAAAAAAAAAAAAACAwYFAQQQAAEDAgMFBgMFBAsAAAAAAAECAwQRBQASBiETFBUHMUFRYSIWgTIjcZFCYhdSkjQIscFygrIzJDVGZicRAAECBAMGBQQDAQAAAAAAAAEAAhEDBAUhMRJBUWGR0SKhseEyE4FCUhXwcRQG/9oADAMBAAIRAxEAPwD6L1brC36ciJW8N9Ldrw8VJoVU7VKO3KkeOIudBc64XFlM2JxccgljJ6n60lvFUV1EdPbumWULAHmXA4cV6yss++1Tz2mH9DrFEWheo15uV4YtVxbQ/v8ANlkITkWkpSVeoD0kenwGJNeularzNmzRLeIx2qXWHVPgpLlvsqEOvNEoeluepCVDYQ2kUzEHvOzyODn7lO43743FkrEjM9EHjqZraoPMaivZuWKf4MR1lcb93V56vBvRF1i6xW7hH1aiSIi47anBIaSpSHAkVy5fUUrPdtofLYMTa+K7lBfmzO2b2u8D6oHufXnUtzllFkZRbolaNZkJefUO4qzZkCvgE/E49JVFVeZpMGdo5laFn6s6wjPDmJRMR+Np1tLSqeRbCKfEHENZXxMvtRLd3QcOIh5JpW7WFsuOnpN5jAqTEacckRjQOJU2grKT9tNhxMOwitNJuMuZJM1v2gkjbgIpU6odfv2vnoi1lIVLTAaJ2hCUubqoH21Vis4lZCucaisLT+Wnxh6pj3m/aZ0DbYkfhXA2/mS03HSkrVuwMy1qUUVPqHfiyIC1U6fIoWNaBnu4bSg2d1m0m8JTVstkiNeJja2m5paYQQpQ+ZTiVleztHnjwlc6fdpWhzmNg8jOAjzVPphpqJebu8/NbD0SClKyyr5VuLJyBQ70+lRp/ViDBFcyxUTZ0wl4i1mzick5XYcR2MYrrDa4xTlLCkgt5R3ZSKUxctsZbS3SQNO5InqDpyJZr+9CYFYclpL7TRJVlQ4VJKCT+ZCqeWKXCBWCu9IKefBvtIiOCP8ApJoa12DTcWbukuXOcjfOylAFQQvahCD+EBFK07Ti0LW2uma2U18O5wjzRLqXTVuv1vcjSW077KeHkU9ba+4g9tK9o78CIq+tomVDC1wx2Hck3pCc/GeukFJ+nOt8xpaa7MzbC3Eq+GUj44paViLdNLS9n5S3jk0lWdbwZti1o9MbqN6+J8R0jYSpec/urqMeuECrbpKfT1RcNrtQ8/NGz+pOnOq7azz1TTTjIzmPIWppTaiKKCHElGYGncduyoricQVoRW0dWwfJAEbDhD6pOdRbloNi6Q0aUhFDMVeeXNK3lb3s9CEuqVQJFdtNp8u0Vx634HdskYb8ceaKNB6va03dFrlpVwEtIRIoDmQQaoXl7TSpqPPEGmBXz2mu/wA006va7A8E0pPUnQ0aGZbl5jlsCuRKszp8t0PXX4Ytith+xkQjrH84JBam6kI1Jq2XLU2WYmRDNvbVTMGmio+qmzMorKvLsxB4isndZhqH6xkMPomZ056rafatbVovEkRHY1Ux5DlS2tBNQlShXKU1pt2Ux60rrWm5sbLEuYYFuR4LX1f1d0xbre81a5qJ1ycSUs7g5m2yRTOpfy+nwFcekr6q67S2MIlnU/ZDZxS90REcnRb5dwkiJbLdLJd7lOuR1pCB/dJJ+HjisNWbt9E5we/Y1juZaQndqDTlrv0LhZ7ZUEmrTqDRxtR70q2/d2YtIitnV0UuobpeOoS2uXRG4LcIh3NlTR73kKQofu5wcQ0LOO/5x4Pa8EccOqv6X6GWS3TW594f5o+0QtqOUZI6VDbVSSVFynnQeIOJBq6dJZmyzF51Hw9URau6dWfUZL5UYc8ihktgEKpsG8QaZqfaDgWxVtdaZVQdXtfv6oAf/l6mPOUN7bS2fxBhRV92cf048DVz2WBw+/w9Ua6P6S6T03FfQGBcJUtssy5UpKVFTavmbSj5UIPeO095OJrr09BLlCGcc4oL1J/LkxIlLf0/dzCZWaiFJQXkpqexLoUFZR3BQJ88eQXxTbM0mLDDgqlm/lsliQhd5vwVHSfWzEaIUoeAccNE/uHCCgyyiPceSb0TS1iiaec0/GjBm1usrYdZQSCpLqSlZK65ipQPzVrj1ddtOxrNAHahW2QLjqWPdb1MvFzQWLhcYcS12x9EZDbVuluxUJFAkrce3G8JcX2qoKJwV6mt2v7fa7fPhz7feI8iyx4z627hw78qQJz7jEZKFsvupUtx5soTnKe7u24IsN21avWFKatuq2XFVKFi821WQnsORb60GngQRgi607LvOsZGnVXG6TYJk6bYuMpu3vGMlcpxwJWshFfu7sEVyBpaS9ra9WhzUV7MOFAt0lhInLCg5KdmJdJVTbsjopgip6kvmoNLs6gszN0lzG2W7I9AnONokzmEXe5Lt8hDYCPrKQlvOzmSpWZVDUAYIvFyIO6Iak65LtKIUI0wKzU2U3jAbr/a9PjswRSS2uobibO5fmbu8ybVHEtrT70RhxNzzKMkyczjWYFG7ybpRQFBf5cEXdvlsxJojTEatjSZ7Eli3tTpDSw+8mOt5TTCm3nEJkbpta285SPT27MEU9+/TPn0/NzvmW8HNPbvuDdb/IP4jk30N9ky1z+ulK4IrVr/AEs9r3zLn5Zs9w8143js2UbvieP/ANdmy03Wbb2ZMEWOP05ps98U7qe96fCmCIp0h7Crafbtc3J2uWZuJzcrzjd13+2uf9v6njgi14nIfc9y4f8A33hIfMf8z+GzyeF7fp/Pv/l2/tfhwRZOpfYHE3nn2Tfcvh813m+/g+Jf4PLk2Z+I3uTd/UzU/LgiFf8Azr/vHw974It7VHtLJbuY+5acMnhuV+5K7vZTieXbd747/wCp44Ism3fpjx3/ACLmHDyuD5r7m3+XcK4jl/H+viNzmpw31qVy4Iv/2Q==);\n" +
                    "}\n" +
                    ".btn-close {\n" +
                    "    font-size: 20px;\n" +
                    "    position: absolute;\n" +
                    "    top: 7px;\n" +
                    "    right: 10px;\n" +
                    "    color: #b9b9b9;\n" +
                    "    display: block;\n" +
                    "    text-decoration: none;\n" +
                    "}\n" +
                    ".error-container {\n" +
                    "    margin: 20px auto 0;\n" +
                    "    padding: 18px 12px;\n" +
                    "    border: 2px solid #f3f3f3;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #fff;\n" +
                    "    text-align: center;\n" +
                    "    max-width: 70%;\n" +
                    "}\n" +
                    ".meter {\n" +
                    "            height: 20px;  /* Can be anything */\n" +
                    "            position: relative;\n" +
                    "            margin: 20px 0 20px 0; /* Just for demo spacing */\n" +
                    "            background: #f2f2f2;\n" +
                    "            -moz-border-radius: 8px;\n" +
                    "            -webkit-border-radius: 8px;\n" +
                    "            border-radius: 8px;\n" +
                    "            padding: 10px;\n" +
                    "            -webkit-box-shadow: inset 0 -1px 1px rgba(0, 0, 0, 0.14);\n" +
                    "            -moz-box-shadow   : inset 0 -1px 1px rgba(0, 0, 0, 0.14);\n" +
                    "            box-shadow        : inset 0 -1px 1px rgba(0, 0, 0, 0.14);\n" +
                    "        }\n" +
                    "        .meter > span {\n" +
                    "            display: block;\n" +
                    "            height: 100%;\n" +
                    "               -webkit-border-top-right-radius: 5px;\n" +
                    "            -webkit-border-bottom-right-radius: 5px;\n" +
                    "                   -moz-border-radius-topright: 5px;\n" +
                    "                -moz-border-radius-bottomright: 5px;\n" +
                    "                       border-top-right-radius: 5px;\n" +
                    "                    border-bottom-right-radius: 5px;\n" +
                    "                -webkit-border-top-left-radius: 5px;\n" +
                    "             -webkit-border-bottom-left-radius: 5px;\n" +
                    "                    -moz-border-radius-topleft: 5px;\n" +
                    "                 -moz-border-radius-bottomleft: 5px;\n" +
                    "                        border-top-left-radius: 5px;\n" +
                    "                     border-bottom-left-radius: 5px;\n" +
                    "            background-color: #21c17c;\n" +
                    "            background-image: -webkit-gradient(               linear,               left bottom,               left top,               color-stop(0, #1fc07b),               color-stop(1, #21c17c)              );\n" +
                    "            background-image: -moz-linear-gradient(\n" +
                    "              center bottom,\n" +
                    "              rgb(43,194,83) 37%,\n" +
                    "              rgb(84,240,84) 69%\n" +
                    "             );\n" +
                    "            -webkit-box-shadow:\n" +
                    "              inset 0 2px 9px  rgba(255,255,255,0.3),\n" +
                    "              inset 0 -2px 6px rgba(0,0,0,0.4);\n" +
                    "            -moz-box-shadow:\n" +
                    "              inset 0 2px 9px  rgba(255,255,255,0.3),\n" +
                    "              inset 0 -2px 6px rgba(0,0,0,0.4);\n" +
                    "            box-shadow:\n" +
                    "              inset 0 2px 9px  rgba(255,255,255,0.3),\n" +
                    "              inset 0 -2px 6px rgba(0,0,0,0.4);\n" +
                    "            position: relative;\n" +
                    "            overflow: hidden;\n" +
                    "        }\n" +
                    "        .meter > span:after, .animate > span > span {\n" +
                    "            content: \"\";\n" +
                    "            position: absolute;\n" +
                    "            top: 0; left: 0; bottom: 0; right: 0;\n" +
                    "            background-image:\n" +
                    "               -webkit-gradient(linear, 0 0, 100% 100%,\n" +
                    "                  color-stop(.25, rgba(255, 255, 255, .2)),\n" +
                    "                  color-stop(.25, transparent), color-stop(.5, transparent),\n" +
                    "                  color-stop(.5, rgba(255, 255, 255, .2)),\n" +
                    "                  color-stop(.75, rgba(255, 255, 255, .2)),\n" +
                    "                  color-stop(.75, transparent), to(transparent)\n" +
                    "               );\n" +
                    "            background-image:\n" +
                    "                -moz-linear-gradient(\n" +
                    "                  -45deg,\n" +
                    "                  rgba(255, 255, 255, .2) 25%,\n" +
                    "                  transparent 25%,\n" +
                    "                  transparent 50%,\n" +
                    "                  rgba(255, 255, 255, .2) 50%,\n" +
                    "                  rgba(255, 255, 255, .2) 75%,\n" +
                    "                  transparent 75%,\n" +
                    "                  transparent\n" +
                    "               );\n" +
                    "            z-index: 1;\n" +
                    "            -webkit-background-size: 50px 50px;\n" +
                    "            -moz-background-size: 50px 50px;\n" +
                    "            -webkit-animation: move 2s linear infinite;\n" +
                    "               -webkit-border-top-right-radius: 5px;\n" +
                    "            -webkit-border-bottom-right-radius: 5px;\n" +
                    "                   -moz-border-radius-topright: 5px;\n" +
                    "                -moz-border-radius-bottomright: 5px;\n" +
                    "                       border-top-right-radius: 5px;\n" +
                    "                    border-bottom-right-radius: 8px;\n" +
                    "                -webkit-border-top-left-radius: 5px;\n" +
                    "             -webkit-border-bottom-left-radius: 5px;\n" +
                    "                    -moz-border-radius-topleft: 5px;\n" +
                    "                 -moz-border-radius-bottomleft: 5px;\n" +
                    "                        border-top-left-radius: 5px;\n" +
                    "                     border-bottom-left-radius: 5px;\n" +
                    "            overflow: hidden;\n" +
                    "        }\n" +
                    "\n" +
                    "        .animate > span:after {\n" +
                    "            display: none;\n" +
                    "        }\n" +
                    "\n" +
                    "        @-webkit-keyframes move {\n" +
                    "            0% {\n" +
                    "               background-position: 0 0;\n" +
                    "            }\n" +
                    "            100% {\n" +
                    "               background-position: 50px 50px;\n" +
                    "            }\n" +
                    "        }\n" +
                    "\n" +
                    "        .orange > span {\n" +
                    "            background-color: #f1a165;\n" +
                    "            background-image: -moz-linear-gradient(top, #f1a165, #f36d0a);\n" +
                    "            background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0, #f1a165),color-stop(1, #f36d0a));\n" +
                    "            background-image: -webkit-linear-gradient(#f1a165, #f36d0a);\n" +
                    "        }\n" +
                    "\n" +
                    "        .red > span {\n" +
                    "            background-color: #f0a3a3;\n" +
                    "            background-image: -moz-linear-gradient(top, #f0a3a3, #f42323);\n" +
                    "            background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0, #f0a3a3),color-stop(1, #f42323));\n" +
                    "            background-image: -webkit-linear-gradient(#f0a3a3, #f42323);\n" +
                    "        }\n" +
                    "\n" +
                    "        .nostripes > span > span, .nostripes > span:after {\n" +
                    "            -webkit-animation: none;\n" +
                    "            background-image: none;\n" +
                    "        }\n" +
                    ".error-container p {    font-size: 14px;     margin: 0 auto;}\n" +
                    ".error-container p i {     font-style: normal;font-weight: 600;}\n" +
                    ".error-title {  padding-bottom: 10px; }\n" +
                    ".error-title hr {\n" +
                    "    height: 2px;\n" +
                    "    max-width: 35%;\n" +
                    "    border-color: transparent;\n" +
                    "    background: #21c17c;\n" +
                    "}\n" +
                    ".btn-error-container {\n" +
                    "    padding-top: 20px;\n" +
                    "    text-align: center;\n" +
                    "    margin: 0 auto;\n" +
                    "    max-width: 80%;\n" +
                    "}\n" +
                    ".btn-error-container img {\n" +
                    "    max-width: 80%;\n" +
                    "}\n" +
                    ".btn {\n" +
                    "    padding: 12px 22px;\n" +
                    "    color: #fff;\n" +
                    "    border-radius: 6px;\n" +
                    "    background: #21c17c;\n" +
                    "    display: inline-block;\n" +
                    "    text-decoration: none;\n" +
                    "    font-weight: 500;\n" +
                    "    font-size: 1.2em;\n" +
                    "}\n" +
                    "\n" +
                    ".btn img {\n" +
                    "\theight: 27px;\n" +
                    "    vertical-align: middle;\n" +
                    "    margin-right: 10px;\n" +
                    "    margin-top: -5px;\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width:390px) {\n" +
                    "\t.head {\n" +
                    "        height: 40px;\n" +
                    "        padding-top: 14px;\n" +
                    "    }\n" +
                    ".container {\n" +
                    "        overflow: hidden;\n" +
                    "        padding: 0 10px;\n" +
                    "    }\n" +
                    ".logo  {\n" +
                    "        font-size: 18px;\n" +
                    "        line-height: 20px;\n" +
                    "        text-align: left;\n" +
                    "    }\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"head\">\n" +
                    "\t<div class=\"container\">\n" +
                    "\t\t<div class=\"logo\"></div>\n" +
                    "\t\t<a class=\"btn-close\" href=\"#\" oonclick=\"exit('1');\">X</a>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<div class=\"container\">\n" +
                    "\t<div class=\"content\">\n" +
                    "\t\t<div class=\"error-container\">\n" +
                    "\t\t\t<div class=\"error-title\"><b>Проверка доступа</b><hr></div>\n" +
                    "\t\t\t<p>Для работы мода <i>" + mod_name + "</i> необходимо наличие на Вашем устройстве приложения \"GooGames\"</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"btn-error-container\">\n" +
                    "                <div class=\"meter\">\n" +
                    "            <span style=\"width: " + percent + "%\"></span>\n" +
                    "        </div>\n" +
                    "\t\t</div>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        }
        return result;
    }
}

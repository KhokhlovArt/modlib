package com.mks.modlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class Lending {
    /*******************************************************************************************
     /*   Лендинги
     ********************************************************************************************/
    static String bckgImageLoading = " \"background-image: url(data:image/jpeg;base64,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);\\n\"";
    static String common = "<!DOCTYPE html>\n" +
            "<html lang=\"ru\">\n" +
            "<head>\n" +
            "<script>\n" +
            "    function download(_id)\n" +
            "    {\n" +
            "        Android.download(_id);\n" +
            "    }\n" +
            "     function openGG(_id)\n" +
            "    {\n" +
            "        Android.openGG(_id);\n" +
            "    }\n" +
            "     function hide(_id)\n" +
            "    {\n" +
            "        Android.hide(_id);\n" +
            "    }\n" +
            "     function subscribe(_id)\n" +
            "    {\n" +
            "        Android.subscribe(_id);\n" +
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
            "}\n" +
            "body, html { height: auto; min-height: 100%; }\n" +
            "b, strong { font-weight: bolder;color: #595e5c;}\n" +
            ".head {\n" +
            "    min-height: 50px;\n" +
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
            "    text-align: center;\n" +
            "    display: inline-block;\n" +
            "    top: 0;\n" +
            "    left: 0;\n" +
            "    width: 100%;\n" +
            "    border-bottom: 5px solid #1aa569;\n" +
            "    background-color: #21c17c;\n" +
            "    background-size: 6vh;\n" +
            "    background-position: 3% center;\n" +
            "    padding: 10px 0;\n" +
            "    color: #fff;\n" +
            "    font-weight: 600;\n" +
            "    background-image: url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gR2VuZXJhdG9yOiBBZG9iZSBJbGx1c3RyYXRvciAxNi4wLjAsIFNWRyBFeHBvcnQgUGx1Zy1JbiAuIFNWRyBWZXJzaW9uOiA2LjAwIEJ1aWxkIDApICAtLT4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB3aWR0aD0iODUuMDg0cHgiIGhlaWdodD0iNTBweCIgdmlld0JveD0iMCAwIDg1LjA4NCA1MCIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAwIDAgODUuMDg0IDUwIiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxnPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNMTAuNjA4LDQ4Ljc5Nkg1LjY1NmMtMC41NjcsMC0xLjEwMi0wLjEwOS0xLjYwNC0wLjMzYy0wLjUwMy0wLjIyLTAuOTQ1LTAuNTE4LTEuMzI2LTAuODk1DQoJCQljLTAuMzgxLTAuMzc2LTAuNjgyLTAuODE0LTAuOTAxLTEuMzE4Yy0wLjIyLTAuNTAzLTAuMzMtMS4wNDItMC4zMy0xLjYxOHYtMS44MzFjMC0wLjU2NSwwLjExLTEuMTAyLDAuMzMtMS42MDQNCgkJCXMwLjUxOC0wLjk0NiwwLjg5NC0xLjMyNmMwLjM3Ni0wLjM4MSwwLjgxNi0wLjY4MSwxLjMxOS0wLjljMC41MDMtMC4yMjEsMS4wNDItMC4zMywxLjYxOS0wLjMzaDYuMTUzdjEuMTEzSDUuNjU2DQoJCQljLTAuNDEsMC0wLjgwMSwwLjA4MS0xLjE3MiwwLjI0MmMtMC4zNzEsMC4xNi0wLjY5NiwwLjM3OC0wLjk3NCwwLjY1MWMtMC4yNzksMC4yNzQtMC40OTksMC41OTQtMC42NTksMC45NTgNCgkJCWMtMC4xNjIsMC4zNjktMC4yNDIsMC43NTctMC4yNDIsMS4xNjh2MS44NTljMCwwLjQxMSwwLjA4LDAuODAyLDAuMjQyLDEuMTcyYzAuMTYxLDAuMzcyLDAuMzc4LDAuNjk2LDAuNjUyLDAuOTc0DQoJCQljMC4yNzMsMC4yOCwwLjU5MywwLjUsMC45NTksMC42NmMwLjM2NiwwLjE2MSwwLjc1NCwwLjI0MiwxLjE2NSwwLjI0Mmg0Ljk4MWMwLjQxLDAsMC44MDEtMC4wODEsMS4xNzItMC4yNDINCgkJCWMwLjM3Mi0wLjE2LDAuNjk2LTAuMzc4LDAuOTc0LTAuNjUxYzAuMjc5LTAuMjc0LDAuNDk5LTAuNTk0LDAuNjYtMC45NmMwLjE2MS0wLjM2NywwLjI0Mi0wLjc1NSwwLjI0Mi0xLjE2NHYtMC40MjdoLTQuNjN2LTEuMTEyDQoJCQloNS43NDR2MS41MDljMCwwLjU2NS0wLjExLDEuMTAyLTAuMzMsMS42MDRjLTAuMjIsMC41MDMtMC41MTgsMC45NDYtMC44OTQsMS4zMjZjLTAuMzc2LDAuMzgxLTAuODE1LDAuNjgxLTEuMzE5LDAuOQ0KCQkJQzExLjcyNCw0OC42ODcsMTEuMTg1LDQ4Ljc5NiwxMC42MDgsNDguNzk2eiIvPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNMjAuNDQsNDguNzk2Yy0wLjY2NCwwLTEuMjY2LTAuMTY3LTEuODAyLTAuNTA2Yy0wLjUzOC0wLjMzNi0wLjkzMy0wLjc5My0xLjE4Ny0xLjM3DQoJCQljLTAuMTc2LTAuMzgxLTAuMjY1LTAuNzg1LTAuMjY1LTEuMjE2YzAtMC40MzksMC4wODYtMC44NDgsMC4yNTctMS4yMjJjMC4xNzEtMC4zNzcsMC40MDMtMC43MDUsMC42OTYtMC45ODINCgkJCWMwLjI5My0wLjI4LDAuNjMzLTAuNDk5LDEuMDE5LTAuNjZjMC4zODYtMC4xNjEsMC43OTMtMC4yNDIsMS4yMjMtMC4yNDJoOC43MzJWNDEuOTFjMC0wLjI5NC0wLjA1OC0wLjU3Mi0wLjE3NS0wLjgzNg0KCQkJcy0wLjI3Ni0wLjQ5MS0wLjQ3Ny0wLjY4Yy0wLjItMC4xOTEtMC40My0wLjM0Ny0wLjY4OC0wLjQ2M2MtMC4yNTktMC4xMTctMC41MzUtMC4xNzYtMC44MjgtMC4xNzZoLTcuMzd2LTEuMTEzaDcuMzcNCgkJCWMwLjQ0OSwwLDAuODc0LDAuMDg1LDEuMjc0LDAuMjU2YzAuNCwwLjE3MSwwLjc0NywwLjQwNCwxLjA0LDAuNzAzYzAuMjkzLDAuMjk4LDAuNTI3LDAuNjQ2LDAuNzAzLDEuMDQNCgkJCWMwLjE3NiwwLjM5NiwwLjI2NCwwLjgxOSwwLjI2NCwxLjI2OXY2Ljg5OUwyMC40NCw0OC43OTZ6IE0xOS4yMzgsNDQuMDYzYy0wLjI5MywwLjE4Ni0wLjUyMiwwLjQyMS0wLjY4OCwwLjcwMg0KCQkJYy0wLjE2NywwLjI4NC0wLjI0OSwwLjU5OC0wLjI0OSwwLjkzOGMwLDAuMjgzLDAuMDU2LDAuNTQ1LDAuMTY4LDAuNzg1YzAuMTEyLDAuMjM5LDAuMjY0LDAuNDQ2LDAuNDU1LDAuNjIxDQoJCQljMC4xOSwwLjE3NiwwLjQxLDAuMzE2LDAuNjU5LDAuNDE3YzAuMjQ5LDAuMTAzLDAuNTE1LDAuMTU1LDAuNzk4LDAuMTU1aDguNzMydi0zLjk3MkgyMC40NGMtMC4yMjUsMC0wLjQ0LDAuMDMyLTAuNjQ1LDAuMDk1DQoJCQlDMTkuNTksNDMuODcsMTkuNDA0LDQzLjk1NywxOS4yMzgsNDQuMDYzeiIvPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNNTAuMTgyLDM4Ljk3M2MwLjUwOCwwLjIyLDAuOTUsMC41MTgsMS4zMjcsMC44OTNjMC4zNzUsMC4zNzYsMC42NzQsMC44MTgsMC44OTQsMS4zMjYNCgkJCWMwLjIxOSwwLjUwNywwLjMyOSwxLjA1MSwwLjMyOSwxLjYyNnY1Ljk3OWgtMS4xMTR2LTUuOTc5YzAtMC40MS0wLjA4LTAuODAxLTAuMjQxLTEuMTcxYy0wLjE2MS0wLjM3MS0wLjM3OC0wLjY5Ny0wLjY1Mi0wLjk3NQ0KCQkJYy0wLjI3My0wLjI3Ny0wLjU5My0wLjUwMS0wLjk1OS0wLjY2OGMtMC4zNjYtMC4xNjUtMC43NTUtMC4yNDgtMS4xNjYtMC4yNDhoLTUuNjI2djkuMDRINDEuODZ2LTkuMDRoLTcuNjkydjkuMDRoLTEuMTEzVjM4LjY0Mw0KCQkJSDQ4LjU3QzQ5LjEzNywzOC42NDMsNDkuNjc0LDM4Ljc1Miw1MC4xODIsMzguOTczeiIvPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNNTUuMTY0LDQxLjcxOWMwLTAuNDI5LDAuMDktMC44MzEsMC4yNzEtMS4yMDhjMC4xODEtMC4zNzYsMC40Mi0wLjcsMC43MTgtMC45NzQNCgkJCWMwLjI5OC0wLjI3NCwwLjY0Mi0wLjQ4OSwxLjAzMy0wLjY0NWMwLjM5MS0wLjE1NywwLjgwNi0wLjIzNSwxLjI0Ni0wLjIzNWg2Ljg1N2MwLjQzLDAsMC44MzcsMC4wOCwxLjIyNCwwLjI0MQ0KCQkJYzAuMzg1LDAuMTYxLDAuNzI1LDAuMzg1LDEuMDE4LDAuNjY2YzAuMjkzLDAuMjg0LDAuNTI3LDAuNjE0LDAuNzA0LDAuOTg4YzAuMTc1LDAuMzc3LDAuMjY0LDAuNzgxLDAuMjY0LDEuMjENCgkJCWMwLDAuNDQxLTAuMDg4LDAuODQ4LTAuMjY0LDEuMjI0Yy0wLjE3NiwwLjM3Ny0wLjQxNiwwLjcwMy0wLjcxOCwwLjk4MmMtMC4zMDMsMC4yNzgtMC42NDksMC40OTctMS4wNCwwLjY1OA0KCQkJYy0wLjM5MSwwLjE2MS0wLjgwNiwwLjI0MS0xLjI0NSwwLjI0MWgtOC45NTN2MS4zOTRjMC4wMzksMC4yNTMsMC4xMjUsMC40NjksMC4yNTYsMC42NDRjMC4xMzIsMC4xNzgsMC4yOTUsMC4zMjIsMC40OTEsMC40MzkNCgkJCWMwLjE5NSwwLjExOCwwLjQxNSwwLjIwMywwLjY1OSwwLjI1N2MwLjI0NCwwLjA1NSwwLjQ5MywwLjA4MSwwLjc0NywwLjA4MWg5LjI4OXYxLjExM2gtOS4zNjJjLTAuMzcyLDAtMC43NDUtMC4wNTktMS4xMi0wLjE3Ng0KCQkJYy0wLjM3Ni0wLjExNi0wLjcxNi0wLjI4My0xLjAxOS0wLjQ5OWMtMC4zMDQtMC4yMTMtMC41NTMtMC40NzctMC43NDgtMC43OTFjLTAuMTk1LTAuMzEyLTAuMjk3LTAuNjY4LTAuMzA3LTEuMDY4VjQxLjcxOXoNCgkJCSBNNTguNDMxLDM5Ljc3MWMtMC4yMTUsMC0wLjQ0OSwwLjA1LTAuNzA0LDAuMTQ2Yy0wLjI1NCwwLjA5OS0wLjQ4OCwwLjIzMS0wLjcwMywwLjQwMmMtMC4yMTUsMC4xNzItMC4zOTQsMC4zNzctMC41MzYsMC42MTYNCgkJCWMtMC4xNDEsMC4yMzktMC4yMTIsMC41MDEtMC4yMTIsMC43ODN2Mi4wMzdoOS4wMTFjMC4yNzQsMCwwLjUzNy0wLjA1MSwwLjc5MS0wLjE1M3MwLjQ3OS0wLjI0NSwwLjY3NC0wLjQyNQ0KCQkJYzAuMTk1LTAuMTgxLDAuMzQ5LTAuMzkxLDAuNDYxLTAuNjMyYzAuMTEyLTAuMjM3LDAuMTY4LTAuNDk5LDAuMTY4LTAuNzgzYzAtMC4yODMtMC4wNTktMC41NDctMC4xNzYtMC43OTENCgkJCWMtMC4xMTctMC4yNDMtMC4yNzYtMC40NTUtMC40NzYtMC42M2MtMC4yLTAuMTc1LTAuNDMtMC4zMTQtMC42ODgtMC40MTdjLTAuMjU5LTAuMTAzLTAuNTMtMC4xNTQtMC44MTMtMC4xNTRINTguNDMxeiIvPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNODAuNzc1LDQ4Ljc5Nkg3MS4wOXYtMS4xMTNoOS42ODZjMC4yMzMsMCwwLjQ1NC0wLjA0NSwwLjY1OC0wLjEzMWMwLjIwNS0wLjA4OSwwLjM4Ny0wLjIxMiwwLjU0My0wLjM2Ng0KCQkJYzAuMTU1LTAuMTU3LDAuMjc3LTAuMzM5LDAuMzY2LTAuNTQ0YzAuMDg4LTAuMjA1LDAuMTMyLTAuNDI1LDAuMTMyLTAuNjZjMC0wLjIzMy0wLjA0NC0wLjQ1NS0wLjEzMi0wLjY2Ng0KCQkJYy0wLjA4OS0wLjIwOS0wLjIwOC0wLjM5My0wLjM1OS0wLjU1Yy0wLjE1MS0wLjE1NC0wLjMzMi0wLjI3Ny0wLjU0Mi0wLjM2NmMtMC4yMS0wLjA4Ni0wLjQzMy0wLjEzMS0wLjY2Ni0wLjEzMWgtNy40MjkNCgkJCWMtMC4zODEsMC0wLjc0My0wLjA3Mi0xLjA4NC0wLjIxOWMtMC4zNDItMC4xNDctMC42NDMtMC4zNDctMC45MDEtMC42MDNjLTAuMjU5LTAuMjUzLTAuNDYyLTAuNTUxLTAuNjA4LTAuODk0DQoJCQljLTAuMTQ2LTAuMzQyLTAuMjItMC43MDgtMC4yMi0xLjA5OXMwLjA3My0wLjc1OSwwLjIyLTEuMTA1YzAuMTQ2LTAuMzQ2LDAuMzQ3LTAuNjQ3LDAuNi0wLjkwMQ0KCQkJYzAuMjU0LTAuMjU0LDAuNTUyLTAuNDU3LDAuODk1LTAuNjA4YzAuMzQxLTAuMTUsMC43MDgtMC4yMjcsMS4wOTgtMC4yMjdoOS42ODZ2MS4xMTRoLTkuNjg2Yy0wLjI0NSwwLTAuNDY2LDAuMDQ1LTAuNjY3LDAuMTM4DQoJCQljLTAuMiwwLjA5NC0wLjM3NiwwLjIxNS0wLjUyOCwwLjM2NmMtMC4xNTEsMC4xNTItMC4yNzEsMC4zMy0wLjM1OSwwLjUzNWMtMC4wODcsMC4yMDUtMC4xMzYsMC40MjUtMC4xNDYsMC42NTgNCgkJCWMwLjAzOSwwLjQ5MSwwLjIxNSwwLjg5OSwwLjUyOCwxLjIzMWMwLjMxMywwLjMzMiwwLjcwMiwwLjQ5OSwxLjE3MiwwLjQ5OWg3LjQyOWMwLjM5MSwwLDAuNzU3LDAuMDczLDEuMDk4LDAuMjINCgkJCWMwLjM0MywwLjE0NSwwLjY0MSwwLjM0NywwLjg5NiwwLjZjMC4yNTIsMC4yNTYsMC40NTMsMC41NTIsMC42LDAuODk0YzAuMTQ2LDAuMzQzLDAuMjIxLDAuNzA5LDAuMjIxLDEuMQ0KCQkJcy0wLjA3NCwwLjc1Ny0wLjIyMSwxLjA5OXMtMC4zNDgsMC42NDMtMC42LDAuOTAxYy0wLjI1NSwwLjI2LTAuNTUzLDAuNDYxLTAuODk2LDAuNjA4DQoJCQlDODEuNTMyLDQ4LjcyMyw4MS4xNjYsNDguNzk2LDgwLjc3NSw0OC43OTZ6Ii8+DQoJPC9nPg0KCTxnPg0KCQk8cGF0aCBmaWxsPSIjRkZGRkZGIiBkPSJNMzIuNTE3LDE3LjU2N2MtMC4xNjgsNC4xMDEtMS43NzUsNy45MDQtNC42MDcsMTAuNjkzYy0yLjg3MywyLjkxNy02Ljc2Miw0LjUyMy0xMC44NjEsNC41MjMNCgkJCWMtNC4yNjksMC04LjE5OS0xLjY0OC0xMS4xMTYtNC42OTJjLTIuODc0LTMuMDAxLTQuNDM4LTYuOTc0LTQuNDM4LTExLjJDMS40OTUsOC4xNDMsOC41OTYsMSwxNy4zODcsMQ0KCQkJYzIuNjYyLDAsNS4yODIsMC42NzcsNy42MDcsMS45MDJjMS42NDgsMC45MjksMi4yNCwyLjk1OCwxLjM1NCw0LjYwNmMtMC44ODksMS42NDgtMi45NTksMi4yNC00LjU2NiwxLjM1Mw0KCQkJYy0xLjM1My0wLjcxOC0yLjg3NC0xLjE0MS00LjM5NS0xLjE0MWMtNS4wMywwLTkuMTMsNC4xNDEtOS4xMyw5LjE3MWMwLDIuNDk0LDAuODg3LDQuODE4LDIuNTM2LDYuNTA5DQoJCQljMS42MDYsMS42ODksMy44NDYsMi42NjEsNi4yNTUsMi42NjFjMy44ODksMCw3LjEtMi41MzUsOC4yNDItNi4xMjhoLTcuNzM0Yy0xLjYwNiwwLTIuOTU5LTEuMzEtMi45NTktMi45NTgNCgkJCWMwLTEuNjA2LDEuMzUzLTIuOTU4LDIuOTU5LTIuOTU4aDExLjc1QzMxLjE2NSwxNC4wNiwzMi42NDQsMTUuNjY2LDMyLjUxNywxNy41Njd6Ii8+DQoJPC9nPg0KCTxsaW5lYXJHcmFkaWVudCBpZD0iU1ZHSURfMV8iIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4MT0iMzIuNTI0OSIgeTE9IjIzLjM5NCIgeDI9IjEuNDk1MSIgeTI9IjIzLjM5NCI+DQoJCTxzdG9wICBvZmZzZXQ9IjAiIHN0eWxlPSJzdG9wLWNvbG9yOiNEMUQzRDQiLz4NCgkJPHN0b3AgIG9mZnNldD0iMC4xNTMzIiBzdHlsZT0ic3RvcC1jb2xvcjojREVERkUwIi8+DQoJCTxzdG9wICBvZmZzZXQ9IjAuNTAxOCIgc3R5bGU9InN0b3AtY29sb3I6I0Y2RjZGNyIvPg0KCQk8c3RvcCAgb2Zmc2V0PSIwLjcxNjEiIHN0eWxlPSJzdG9wLWNvbG9yOiNGRkZGRkYiLz4NCgk8L2xpbmVhckdyYWRpZW50Pg0KCTxwYXRoIGZpbGw9InVybCgjU1ZHSURfMV8pIiBkPSJNMjkuMzA1LDE0LjAxOGgtMTEuNzVjLTEuNjA2LDAtMi45NTksMS4zNTMtMi45NTksMi45NThjMCwxLjY0OSwxLjM1MywyLjk1OCwyLjk1OSwyLjk1OGg3LjczNA0KCQljLTEuMTQyLDMuNTkzLTQuMzUzLDYuMTI4LTguMjQyLDYuMTI4Yy0yLjQwOSwwLTQuNjQ5LTAuOTcyLTYuMjU1LTIuNjYxYy0xLjY0OS0xLjY5MS0yLjUzNi00LjAxNi0yLjUzNi02LjUwOQ0KCQljMC0xLjAwOCwwLjE2Ny0xLjk3OCwwLjQ3LTIuODg4SDEuNzYzYy0wLjE3MywwLjkzOC0wLjI2OCwxLjkwMi0wLjI2OCwyLjg4OGMwLDQuMjI2LDEuNTYzLDguMTk5LDQuNDM4LDExLjINCgkJYzIuOTE3LDMuMDQ0LDYuODQ3LDQuNjkyLDExLjExNiw0LjY5MmM0LjEsMCw3Ljk4OC0xLjYwNiwxMC44NjEtNC41MjNjMi44MzItMi43OSw0LjQzOS02LjU5Myw0LjYwNy0xMC42OTMNCgkJQzMyLjY0NCwxNS42NjYsMzEuMTY1LDE0LjA2LDI5LjMwNSwxNC4wMTh6Ii8+DQoJPGc+DQoJCTxsaW5lYXJHcmFkaWVudCBpZD0iU1ZHSURfMl8iIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4MT0iMjYuNzgyNyIgeTE9IjE2Ljg5MjEiIHgyPSI1OC41NjY0IiB5Mj0iMTYuODkyMSI+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwIiBzdHlsZT0ic3RvcC1jb2xvcjojRkZGRkZGIi8+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwLjQzNTUiIHN0eWxlPSJzdG9wLWNvbG9yOiNGN0Y4RjgiLz4NCgkJCTxzdG9wICBvZmZzZXQ9IjEiIHN0eWxlPSJzdG9wLWNvbG9yOiNEMUQzRDQiLz4NCgkJPC9saW5lYXJHcmFkaWVudD4NCgkJPHBhdGggZmlsbD0idXJsKCNTVkdJRF8yXykiIGQ9Ik01OC41NjYsMTYuODkyYzAsOC43OS03LjEwMSwxNS44OTItMTUuODkyLDE1Ljg5MmMtOC43NDksMC0xNS44OTItNy4xMDItMTUuODkyLTE1Ljg5Mg0KCQkJQzI2Ljc4Myw4LjEsMzMuOTI2LDEsNDIuNjc1LDFDNTEuNDY1LDEsNTguNTY2LDguMSw1OC41NjYsMTYuODkyeiBNMzMuNTQ1LDE2Ljg5MmMwLDUuMDcsNC4wMTUsOS4xNjksOS4wODYsOS4xNjkNCgkJCWM0Ljk4OCwwLDkuMTcyLTQuMTg0LDkuMTcyLTkuMTY5YzAtNC45ODgtNC4xODQtOS4xNzItOS4xNzItOS4xNzJDMzcuNTYxLDcuNzIsMzMuNTQ1LDExLjgyLDMzLjU0NSwxNi44OTJ6Ii8+DQoJCTxsaW5lYXJHcmFkaWVudCBpZD0iU1ZHSURfM18iIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4MT0iNTEuODA2NiIgeTE9IjE2Ljg5MjEiIHgyPSI4My41ODg5IiB5Mj0iMTYuODkyMSI+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwIiBzdHlsZT0ic3RvcC1jb2xvcjojRDFEM0Q0Ii8+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwLjIzMDEiIHN0eWxlPSJzdG9wLWNvbG9yOiNFOUVBRUEiLz4NCgkJCTxzdG9wICBvZmZzZXQ9IjAuNDI0NyIgc3R5bGU9InN0b3AtY29sb3I6I0Y5RjlGOSIvPg0KCQkJPHN0b3AgIG9mZnNldD0iMSIgc3R5bGU9InN0b3AtY29sb3I6I0ZGRkZGRiIvPg0KCQk8L2xpbmVhckdyYWRpZW50Pg0KCQk8cGF0aCBmaWxsPSJ1cmwoI1NWR0lEXzNfKSIgZD0iTTgzLjU4OSwxNi44OTJjMCw4Ljc5LTcuMTAxLDE1Ljg5Mi0xNS44OTMsMTUuODkyYy04Ljc0OCwwLTE1Ljg5LTcuMTAyLTE1Ljg5LTE1Ljg5Mg0KCQkJQzUxLjgwNyw4LjEsNTguOTQ5LDEsNjcuNjk2LDFDNzYuNDg4LDEsODMuNTg5LDguMSw4My41ODksMTYuODkyeiBNNTguNTY4LDE2Ljg5MmMwLDUuMDcsNC4wMTUsOS4xNjksOS4wODcsOS4xNjkNCgkJCWM0Ljk4NywwLDkuMTcxLTQuMTg0LDkuMTcxLTkuMTY5YzAtNC45ODgtNC4xODQtOS4xNzItOS4xNzEtOS4xNzJDNjIuNTgzLDcuNzIsNTguNTY4LDExLjgyLDU4LjU2OCwxNi44OTJ6Ii8+DQoJCTxsaW5lYXJHcmFkaWVudCBpZD0iU1ZHSURfNF8iIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4MT0iNTUuMTg2IiB5MT0iMzIuNzg0MiIgeDI9IjU1LjE4NiIgeTI9IjEuMDAwNSI+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwIiBzdHlsZT0ic3RvcC1jb2xvcjojRDFEM0Q0Ii8+DQoJCQk8c3RvcCAgb2Zmc2V0PSIwLjM3MiIgc3R5bGU9InN0b3AtY29sb3I6I0ZGRkZGRiIvPg0KCQk8L2xpbmVhckdyYWRpZW50Pg0KCQk8cGF0aCBmaWxsPSJ1cmwoI1NWR0lEXzRfKSIgZD0iTTc2LjgyNiwxNi44ODljMCwwLDAsMC4wMDIsMCwwLjAwM2MwLDQuOTg2LTQuMTg0LDkuMTY5LTkuMTcxLDkuMTY5DQoJCQljLTUuMDcyLDAtOS4wODctNC4wOTktOS4wODctOS4xNjljMC0wLjAwMSwwLTAuMDAzLDAtMC4wMDNoLTAuMDAxQzU4LjU2NSw4LjA5OCw1MS40NjMsMSw0Mi42NzUsMQ0KCQkJYy04Ljc0OSwwLTE1Ljg5Miw3LjEtMTUuODkyLDE1Ljg5MWg2Ljc2M2MwLTUuMDcxLDQuMDE1LTkuMTcsOS4wODYtOS4xN2M0Ljk4OCwwLDkuMTcyLDQuMTg0LDkuMTcyLDkuMTdoMC4wMDN2MC4wMDENCgkJCWMwLDguNzksNy4xNDIsMTUuODkyLDE1Ljg5LDE1Ljg5MmM4Ljc5MiwwLDE1Ljg5My03LjEwMiwxNS44OTMtMTUuODkyYzAtMC4wMDEsMC0wLjAwMywwLTAuMDAzSDc2LjgyNnoiLz4NCgk8L2c+DQo8L2c+DQo8L3N2Zz4NCg==');\n" +
            "}\n" +
            ".icon {\n" +
            "    text-align: center;\n" +
            "    margin: 0 auto;\n" +
            "    overflow: hidden;\n" +
            "}\n" +
            ".icon img {\n" +
            "    max-width: 10vh;\n" +
            "    border-radius: 10px;\n" +
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
            "    margin: 15px auto 0;\n" +
            "    padding: 10px 12px 15px 12px;\n" +
            "    border: 2px solid #f3f3f3;\n" +
            "    border-radius: 6px;\n" +
            "    background: #fff;\n" +
            "    text-align: center;\n" +
            "    max-width: 85%;\n" +
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
            "    padding: 18px 25px 8px 25px;\n" +
            "    max-width: 70%;\n" +
            "    background: #f8f8f8;\n" +
            "}\n" +
            ".btn-container {\n" +
            "    text-align: center;\n" +
            "    margin: 20px auto 0;\n" +
            "    padding: 15px 0 0 0;\n" +
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
            ".btn.game {\n" +
            "\tmargin-top: 15px;\n" +
            "background: #21c17c;\n" +
            "background: -moz-linear-gradient(45deg, #21c17c 0%, #21c17c 50%, #21c17c 50%, #1aa569 51%, #21c17c 100%);\n" +
            "background: -webkit-linear-gradient(45deg, #21c17c 0%,#21c17c 50%,#21c17c 50%,#1aa569 51%,#21c17c 100%);\n" +
            "background: linear-gradient(45deg, #21c17c 0%,#21c17c 50%,#21c17c 50%,#1aa569 51%,#21c17c 100%);\n" +
            "filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#21c17c', endColorstr='#21c17c',GradientType=1 );\n" +
            "}\n" +
            ".btn.game.disable {\n" +
            "background: #9c9c9c;\n" +
            "background: -moz-linear-gradient(top, #9c9c9c 0%, #cccccc 100%);\n" +
            "background: -webkit-linear-gradient(top, #9c9c9c 0%,#cccccc 100%);\n" +
            "background: linear-gradient(to bottom, #9c9c9c 0%,#cccccc 100%);\n" +
            "filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#9c9c9c', endColorstr='#cccccc',GradientType=0 );\n" +
            "    color: #ebebeb;\n" +
            "    font-size: 1em;\n" +
            "}\n" +
            ".btn-container em {\n" +
            "\tfont-style: normal;\n" +
            "    font-size: 0.6em;\n" +
            "    color: #9d9d9d;\n" +
            "    text-align: right;\n" +
            "}\n" +
            ".btn.game b {color: inherit;}\n" +
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
            "    margin-bottom: 0;\n" +
            "    }\n" +
            "    .logo {background-size: 10vh;}\n" +
            "    .error-container p {font-size: 0.9em;}\n" +
            "    .error-title {   padding-bottom: 5px;}\n" +
            "    .btn-error-container {\n" +
            "    max-width: inherit;\n" +
            "    margin: 0 auto;\n" +
            "    padding: 10px 15px;\n" +
            "    text-align: center;\n" +
            "    display: flex;\n" +
            "    }\n" +
            "    label.container {\n" +
            "    font-size: 12px;\n" +
            "    margin-bottom: 0;\n" +
            "    }\n" +
            "    .error-container {\n" +
            "    margin: 5px auto 0;\n" +
            "    font-size: 0.8em;\n" +
            "    max-width: 95%;\n" +
            "    margin-bottom: 0;\n" +
            "    padding: 10px 5px;\n" +
            "    }\n" +
            "    .btn {\n" +
            "    vertical-align: middle;\n" +
            "    padding: 0.8em 1.4em;\n" +
            "    }\n" +
            "    .btn.game {\n" +
            "    margin-top: 0;\n" +
            "    padding: 0.5em 1em;\n" +
            "    }\n" +
            "    .btn-container {\n" +
            "    margin: 0 auto;\n" +
            "    }\n" +
            "    .btn-container br.land, .btn-container em {    display: none;}\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"head\">\n" +
            "\t<div class=\"container\">\n" +
            "\t\t<div class=\"logo\">" + Localization.getString("Access check") + "</div>\n" +
            "\t</div>\n" +
            "</div>\n" +
            "<div class=\"container\">\n" +
            "\t<div class=\"content\">";

    static String picApp = "";
    static String stepOne = "<div class=\"error-title\"><b>" + Localization.getString("step1_2")  + "</b><hr></div>";
    static String stepTwo = "<div class=\"error-title\"><b>" + Localization.getString("step2_2")  + "</b><hr></div>";
    // static String stepGranted = "<div class=\"error-title\"><b style=\"color: #1db071;\">Доступ успешно предоставлен!</b><hr></div>";
    static String result = "";


    static String installButton = " <a class=\"btn\" href=\"#\"> <img src=\"data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjMycHgiIGhlaWdodD0iMzJweCIgdmlld0JveD0iMCAwIDYxMiA2MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDYxMiA2MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPGc+Cgk8ZyBpZD0iY2xvdWQtZG93bmxvYWQiPgoJCTxwYXRoIGQ9Ik00OTQuNywyNTVDNDc2Ljg1LDE2OC4zLDQwMC4zNSwxMDIsMzA2LDEwMmMtNzMuOTUsMC0xMzcuNyw0MC44LTE2OC4zLDEwMkM1OC42NSwyMTQuMiwwLDI3Ny45NSwwLDM1NyAgICBjMCw4NC4xNSw2OC44NSwxNTMsMTUzLDE1M2gzMzEuNWM3MS40LDAsMTI3LjUtNTYuMSwxMjcuNS0xMjcuNUM2MTIsMzE2LjIsNTU4LjQ1LDI2MC4xLDQ5NC43LDI1NXogTTQzMy41LDMzMS41TDMwNiw0NTkgICAgTDE3OC41LDMzMS41SDI1NXYtMTAyaDEwMnYxMDJINDMzLjV6IiBmaWxsPSIjRkZGRkZGIi8+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==\" /> " + Localization.getString("install_GooGames") + "</a><br class=\"land\">\n";
//            "<a class=\"btn\" href=\"#\"><img src=\"data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjMycHgiIGhlaWdodD0iMzJweCIgdmlld0JveD0iMCAwIDYxMiA2MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDYxMiA2MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPGc+Cgk8ZyBpZD0iY2xvdWQtZG93bmxvYWQiPgoJCTxwYXRoIGQ9Ik00OTQuNywyNTVDNDc2Ljg1LDE2OC4zLDQwMC4zNSwxMDIsMzA2LDEwMmMtNzMuOTUsMC0xMzcuNyw0MC44LTE2OC4zLDEwMkM1OC42NSwyMTQuMiwwLDI3Ny45NSwwLDM1NyAgICBjMCw4NC4xNSw2OC44NSwxNTMsMTUzLDE1M2gzMzEuNWM3MS40LDAsMTI3LjUtNTYuMSwxMjcuNS0xMjcuNUM2MTIsMzE2LjIsNTU4LjQ1LDI2MC4xLDQ5NC43LDI1NXogTTQzMy41LDMzMS41TDMwNiw0NTkgICAgTDE3OC41LDMzMS41SDI1NXYtMTAyaDEwMnYxMDJINDMzLjV6IiBmaWxsPSIjRkZGRkZGIi8+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==\" /> Установить GooGames</a><br class=\"land\">\n";


    public static String getLending(Context cnt, String mod_name, String type, int percent) {
        result = "";
        picApp = "<div class=\"icon\"><img src=\"data:image/png;base64," + InfoForm.picAppOnlyStr +
                "\"></div><div class=\"error-container\">";
        if (type.equals("ordinary")) {
            result = result + common + picApp;
            Logger.log("InfoForm.resultExtStrgGranted " + InfoForm.resultExtStrgGranted + " resultGooInstalled " + InfoForm.resultGooInstalled + " resultSMSGranted" + InfoForm.resultSMSGranted + " resultPhoneCallGranted" + InfoForm.resultPhoneCallGranted);
            if (InfoForm.resultGooInstalled == -1) {
                result = result + stepOne + "<p>" +  Localization.getString("For work mod 1") +  " <i>" + mod_name + "</i> " +  Localization.getString("For work mod 2") + "</p>\n" +
                        "</div>\n" +
                        "<div class=\"btn-error-container\">\n" +
                        "            <label class=\"container\">" + Localization.getString("install_GooGames") + "\n" +
                        "              <input type=\"checkbox\" onclick='window.event.returnValue=false'>\n" +
                        "              <span class=\"checkmark\"></span>\n" +
                        "            </label>\n" +
                        "\n" +
                        "            <label class=\"container\">"+Localization.getString("Give access")+"\n" +
                        "              <input type=\"checkbox\" onclick='window.event.returnValue=false'>\n" +
                        "              <span class=\"checkmark\"></span>\n" +
                        "            </label>\n" +
                        "\t\t</div>\n <div class=\"btn-container\"  onclick=\"download('1');\">" +  installButton + "</div>\n" +
                        "\t\t <div class=\"btn-container\"> <a class=\"btn game disable\" href=\"#\" onclick=\"\">"+Localization.getString("Play")+"<br><b>"+ mod_name+"</b></a><br>\n" +
                        "            <em>"+Localization.getString("Activate where")+"</em>\n" +
                        "        </div>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>";
            } else if (InfoForm.resultGooInstalled == 0 && InfoForm.resultAllGranted) {  /**All Granted*/
                 // Только для модов DrHack - добавляем проверку подписки на канал
                int subscribeCode = 1;
                ApplicationInfo ai = null;
                String channel_link = null;
                if (cnt != null) {
                    subscribeCode = cnt.getSharedPreferences(C.SESSION_SUBSCRIBE, Context.MODE_PRIVATE).getInt(C.KEY_SUBSCRIBE, 0);
                    //Первый старт и по такому ключу данных не найдено - значит надо показать окно с подпиской на канал
                    if (subscribeCode == 0) {subscribeCode = -1;}
                    try {
                        ai = cnt.getPackageManager().getApplicationInfo(cnt.getPackageName(), PackageManager.GET_META_DATA);
                        Bundle bundle = ai.metaData;
                        channel_link = bundle.getString(C.KEY_USER_CHANNEL);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                }

                 if ((subscribeCode == 1)||(channel_link == null)) {
                    result = result + "\t\t<div class=\"error-title\"><b style=\"color: #1db071;\">" + Localization.getString("Access granted") + "</b><hr></div>\n" +
                            "\t\t\t<p>" + Localization.getString("For play 1") + " <i>" + mod_name + "</i> " + Localization.getString("For play 2") + " </p>\n" +
                            "\t\t</div>\n" +
                            "\t\t<div class=\"btn-error-container\">\n" +
                            "            <label class=\"container\">" + Localization.getString("install_GooGames") + "\n" +
                            "              <input type=\"checkbox\" checked onclick='window.event.returnValue=false'>\n" +
                            "              <span class=\"checkmark\"></span>\n" +
                            "            </label>\n" +
                            "\n" +
                            "            <label class=\"container\">" + Localization.getString("Give access") + "\n" +
                            "              <input type=\"checkbox\" checked onclick='window.event.returnValue=false'>\n" +
                            "              <span class=\"checkmark\"></span>\n" +
                            "            </label>\n" +
                            "\t\t</div>\n" +
                            "        <div class=\"btn-container\" >\n" +
                            "            <a class=\"btn game\" href=\"#\"  onclick=\"hide('1');\"> " + Localization.getString("Play") + "<br><b>" + mod_name + "</b></a><br>\n" +
                            "        </div>\n" +
                            "\t</div>\n" +
                            "</div>\n" +
                            "</body>\n" +
                            "</html>";
                 }
                 else
                 {
                     result = result + "\t\t<div class=\"error-title\"><b style=\"color: #1db071;\">" + Localization.getString("Access granted") + "</b><hr></div>\n" +
                             "\t\t\t<p>" + Localization.getString("For play 1 DrHack") + " <i>" + mod_name + "</i> " + Localization.getString("For play 2 DrHack") + " </p>\n" +
                             "\t\t</div>\n" +
                             "\t\t<div class=\"btn-error-container\">\n" +
                             "            <label class=\"container\">" + Localization.getString("install_GooGames") + "\n" +
                             "              <input type=\"checkbox\" checked onclick='window.event.returnValue=false'>\n" +
                             "              <span class=\"checkmark\"></span>\n" +
                             "            </label>\n" +
                             "\n" +
                             "            <label class=\"container\">" + Localization.getString("Give access") + "\n" +
                             "              <input type=\"checkbox\" checked onclick='window.event.returnValue=false'>\n" +
                             "              <span class=\"checkmark\"></span>\n" +
                             "            </label>\n" +
                             "\t\t</div>\n" +
                             "        <div class=\"btn-container\">\n" +
                             "            <a  style = \"background: #cc181e;\" class=\"btn game\" href=\"#\"  onclick=\"subscribe('" + channel_link + "');\"> " + Localization.getString("Subscribe") + "<br></a><br>\n" +
                             "        </div>\n" +
                             "\t</div>\n" +
                             "</div>\n" +
                             "</body>\n" +
                             "</html>";
                 }
            } /**With no or one permissions*/
            else if (InfoForm.resultGooInstalled == 0 && !InfoForm.resultAllGranted) {
                result = result + stepTwo;
                if ((InfoForm.resultExtStrgGranted == -1 && InfoForm.resultPhoneCallGranted == -1 && InfoForm.resultSMSGranted == -1)
                        || (InfoForm.resultExtStrgGranted == 0 && InfoForm.resultPhoneCallGranted == -1 && InfoForm.resultSMSGranted == -1)
                        || (InfoForm.resultExtStrgGranted == -1 && InfoForm.resultPhoneCallGranted == -1 && InfoForm.resultSMSGranted == 0)
                        || (InfoForm.resultExtStrgGranted == -1 && InfoForm.resultPhoneCallGranted == 0 && InfoForm.resultSMSGranted == -1)) {
                    result = result +
                            "<p>"+Localization.getString("To play mod")+" <i>" + mod_name + "</i>"+Localization.getString("To play mod 1")+"</p>\n";
                } else if ((InfoForm.resultExtStrgGranted == 0 && InfoForm.resultPhoneCallGranted == 0 && InfoForm.resultSMSGranted == -1)) {
                    result = result + "<p>"+Localization.getString("To play mod")+" <i>" + mod_name + "</i>"+Localization.getString("To play mod 2")+"</p>";
                } else if (InfoForm.resultGooInstalled == 0 && ((InfoForm.resultExtStrgGranted == 0 && InfoForm.resultPhoneCallGranted == -1 && InfoForm.resultSMSGranted == 0))) {
                    result = result + "<p>"+Localization.getString("To play mod")+" <i>" + mod_name + "</i>"+Localization.getString("To play mod 3")+"</p>";
                } else if (InfoForm.resultGooInstalled == 0 && ((InfoForm.resultExtStrgGranted == -1 && InfoForm.resultPhoneCallGranted == 0 && InfoForm.resultSMSGranted == 0))) {
                    result = result + "<p>"+Localization.getString("To play mod")+"<i>" + mod_name + "</i>"+Localization.getString("To play mod 4")+"</p>";
                }
                result = result + "</div>\n" +
                        "\t\t<div class=\"btn-error-container\">\n" +
                        "            <label class=\"container\">"+Localization.getString("install_GooGames")+"\n" +
                        "              <input type=\"checkbox\" checked onclick='window.event.returnValue=false'>\n" +
                        "              <span class=\"checkmark\"></span>\n" +
                        "            </label>\n" +
                        "\n" +
                        "            <label class=\"container\">"+Localization.getString("Give access")+"\n" +
                        "              <input type=\"checkbox\" onclick='window.event.returnValue=false'>\n" +
                        "              <span class=\"checkmark\"></span>\n" +
                        "            </label>\n" +
                        "\t\t</div>\n" +
                        "        <div class=\"btn-container\">\n" +
                        "            <a class=\"btn\" href=\"#\"onclick=\"openGG('1');\"><img src=\"data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjMycHgiIGhlaWdodD0iMzJweCIgdmlld0JveD0iMCAwIDEwNi4wNDggMTA2LjA0OCIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMTA2LjA0OCAxMDYuMDQ4OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CjxnPgoJPHBhdGggZD0iTTY5Ljg5NSwzNC4yNzlsNy40OTgsNy40OThMNDcuNDAzLDcxLjc2OWwtMTguNzUtMTguNzQ1bDcuNDk4LTcuNDk4bDExLjI0NywxMS4yNDdMNjkuODk1LDM0LjI3OXogICAgTTEwNi4wNDgsMjEuMjA5djYzLjYyOWMwLDExLjY2Ni05LjU0MywyMS4yMS0yMS4yMSwyMS4yMUgyMS4yMDlDOS41NDMsMTA2LjA0OCwwLDk2LjUwNCwwLDg0LjgzOFYyMS4yMDkgICBDMCw5LjU0Myw5LjU0MywwLDIxLjIwOSwwaDYzLjYyOEM5Ni41MDUsMCwxMDYuMDQ4LDkuNTQzLDEwNi4wNDgsMjEuMjA5eiBNOTIuNzkyLDUzLjAyM2MwLTIxLjk2OC0xNy44MDMtMzkuNzY4LTM5Ljc2OS0zOS43NjggICBjLTIxLjk2OCwwLTM5Ljc2OCwxNy44LTM5Ljc2OCwzOS43NjhjMCwyMS45NjYsMTcuOCwzOS43NjksMzkuNzY4LDM5Ljc2OUM3NC45ODksOTIuNzkyLDkyLjc5Miw3NC45ODksOTIuNzkyLDUzLjAyM3oiIGZpbGw9IiNGRkZGRkYiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K\" />"+Localization.getString("Give permission")+" </a><br class=\"land\">\n" +
                        "            <a class=\"btn game disable\" href=\"#\" onclick=\"\">"+Localization.getString("Play")+"<br><b>" + mod_name + "</b></a><br>\n" +
                        "            <em>"+Localization.getString("Activate where")+"</em>\n" +
                        "        </div>\n" +
                        "\t</div>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>";
            }
        }
        if (type.equals("loading")) {
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
                    bckgImageLoading +
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
                    "\t\t\t<div class=\"error-title\"><b>"+Localization.getString("Access check")+"</b><hr></div>\n" +
                    "\t\t\t<p>"+Localization.getString("For work mod 1")+"<i>" + mod_name + "</i> "+Localization.getString("For work mod 2")+"</p>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"btn-error-container\">\n" +
                    "        <img src=\"data:image/gif;base64," + InfoForm.picAppOnlyStr+"\">\n" +
                    "\t\t</div>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        }
        if (type.equals("loadingPercent"))

        {
            result = result + "<!DOCTYPE html>\n" +
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
                    bckgImageLoading +
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
                    "\t\t<a class=\"btn-close\" href=\"#\" onclick=\"exit('1');\">X</a>\n" +
                    "\t</div>\n" +
                    "</div>\n" +
                    "<div class=\"container\">\n" +
                    "\t<div class=\"content\">\n" +
                    "\t\t<div class=\"error-container\">\n" +
                    "\t\t\t<div class=\"error-title\"><b>"+Localization.getString("Access check")+"</b><hr></div>\n" +
                    "\t\t\t<p>"+Localization.getString("For work mod 1")+"<i>" + mod_name + "</i> "+Localization.getString("For work mod 2")+"</p>\n" +
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

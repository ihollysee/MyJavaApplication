package com.company.liang;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
//        String jsonStringOk = "{\"adcode\": 120000, \"name\": \"\\u5929\\u5929\"}";
//        String jsonString = "{\"adcode\": 120000, \"name\": \"\\u5929\\u6{\"t\"}";//含有非法字符
//
//        String josnStr = "{[\"\\u6{\"t]}";
//
//        JSONObject json = new JSONObject(josnStr);
//        System.out.println(json.toString());
//
//
//        Boolean data = null;
//        if (Boolean.TRUE.equals(data)) {//不会崩溃
//        }

        String CRLF = "buildNumber:075\n" +
                "\n" +
                "AndroidManifest.xml,android:versionName:7.6.6.1075\n" +
                "\n" +
                "buildNumberWithoutZero:75\n" +
                "\n" +
                "564\n" +
                "7.6.6.1075\n" +
                "\n" +
                "[workspace] ";

        System.out.print(CRLF.replaceAll("(\\r\\n|\\r|\\n|\\n\\r)", ""));
    }
}

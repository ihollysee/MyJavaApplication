package com.company.liang;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        String jsonStringOk = "{\"adcode\": 120000, \"name\": \"\\u5929\\u5929\"}";
        String jsonString = "{\"adcode\": 120000, \"name\": \"\\u5929\\u6{\"t\"}";//含有非法字符

        String josnStr = "{[\"\\u6{\"t]}";

        JSONObject json = new JSONObject(josnStr);
        System.out.println(json.toString());
    }
}

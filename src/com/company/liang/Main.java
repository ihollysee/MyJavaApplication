package com.company.liang;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"adcode\": 120000, \"name\": \"\\u5929\\u6{\\\"}";//含有非法字符
        String jsonStringOk = "{\"adcode\": 120000, \"name\": \"\\u5929\\u5929\"}";
        JSONObject json = new JSONObject(jsonStringOk);
        System.out.println(json.toString());
    }
}

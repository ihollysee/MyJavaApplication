package com.company.liang;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"adcode\": 120000, \"name\": \"\\u5929\\u6{\\\"}";
        JSONObject json = new JSONObject(jsonString);
    }
}

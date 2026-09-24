package com.sandc.crystal.web.app;

import org.json.JSONObject;

import com.sandc.crystal.web.util.ResponseObjectSetup;

public class App1 {
    public static void main (String[] args) {
        JSONObject jsonObject = ResponseObjectSetup.getJSONResponseObjectTemplate();

        System.out.println(JSONObject.valueToString(jsonObject));

        jsonObject.put("data", "Data");

        System.out.println(JSONObject.valueToString(jsonObject));

    }
}

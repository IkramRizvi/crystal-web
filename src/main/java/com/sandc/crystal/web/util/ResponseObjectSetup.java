package com.sandc.crystal.web.util;

import org.json.JSONObject;

public final class ResponseObjectSetup {

    public static JSONObject getJSONResponseObjectTemplate() {
        JSONObject response = new JSONObject();
        response.put("command", "");
        response.put("ECD", 0);
        response.put("ETX", "");
        response.put("success", true);
        response.put("message", "");
        response.put("data", JSONObject.NULL);
        return response;
    }
}
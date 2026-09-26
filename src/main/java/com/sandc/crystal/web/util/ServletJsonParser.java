package com.sandc.crystal.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public final class ServletJsonParser {

    public static JSONObject parseRequestBody(HttpServletRequest request) {
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading request body: " + e.getMessage());
            return null;
        }

        // Convert the assembled string into a JSONObject
        return new JSONObject(jsonBuffer.toString());
    }
}

package com.sandc.crystal.web.app;

import org.json.JSONObject;

import com.sandc.crystal.base.model.Type;

public class App2 {
    public static void main (String args[]) {
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject1.put("parentKey","parent value");
        jsonObject2.put("childKey","child value");
        jsonObject1.put("childObjectKey",jsonObject2);

        System.out.println("From org.json.JSONObject:");
        System.out.println(JSONObject.valueToString(jsonObject1));

        Type type = new Type();
        type.setId("id value");
        type.setName("name value");
        type.setDescription("description value");

        System.out.println("From com.sandc.crystal.base.model.Type.toString:");
        System.out.println(type.toString());

        System.out.println("From com.sandc.crystal.base.model.Type:");
        System.out.println(type);

        System.out.println("From org.json.JSONObject.valueToString(type):");
        System.out.println(JSONObject.valueToString(type));

    }
}

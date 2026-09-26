package com.sandc.crystal.web.app;

import org.json.JSONObject;

import com.sandc.crystal.base.dao.TypeDAOImpl;
import com.sandc.crystal.base.model.Type;
import com.sandc.crystal.web.util.ResponseObjectSetup;

public class App1 {
    public static void main (String[] args) {
        JSONObject jsonObject = ResponseObjectSetup.getJSONResponseObjectTemplate();

        System.out.println(JSONObject.valueToString(jsonObject));

        TypeDAOImpl typeDAOImpl = new TypeDAOImpl();
        Type type = typeDAOImpl.retrieve("3fe0b895-951b-42b2-a0f6-2bad7d14b6c8");

        jsonObject.put("data", type.toString());

        System.out.println(JSONObject.valueToString(jsonObject));

    }
}

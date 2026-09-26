package com.sandc.crystal.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sandc.crystal.base.dao.TypeDAOImpl;
import com.sandc.crystal.base.model.Type;
import com.sandc.crystal.web.util.ResponseObjectSetup;
import com.sandc.crystal.web.util.ServletJsonParser;

public class GetType extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(GetType.class) ;

    private JSONObject requestJsonObject;
    private JSONObject responseJsonObject;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        if ((request.getContentType().equalsIgnoreCase("application/json")) && request.getContentLength() > 0) {
            requestJsonObject = ServletJsonParser.parseRequestBody(request);
            String id = requestJsonObject.getString("id");
            TypeDAOImpl typeDAOImpl = new TypeDAOImpl();
            Type type = typeDAOImpl.retrieve(id);
            responseJsonObject = ResponseObjectSetup.getJSONResponseObjectTemplate();
            responseJsonObject.put("data", type.toJson());
        }
        else {
            responseJsonObject = ResponseObjectSetup.getJSONResponseObjectTemplate();
            responseJsonObject.put("ECD",1);
            responseJsonObject.put("success","false");
            responseJsonObject.put("Content-Type in Request:",request.getContentType());
            responseJsonObject.put("ETX", "Invalid request media: " + request.getContentType());
            try {
                response.getWriter().write(JSONObject.valueToString(responseJsonObject));
            }
            catch (Exception e) {
                logger.error(e.toString());
            }
            return;
        }
        try {
            response.getWriter().write(JSONObject.valueToString(responseJsonObject));
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
    }
}

package com.sandc.crystal.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.sandc.crystal.base.util.ReadProperties;
import com.sandc.crystal.web.util.ResponseObjectSetup;

public class TestJSONResponse extends HttpServlet {
    private JSONObject jsonObject;
    private JSONObject jsonObjectData;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                response.setContentType("application/json");

                String propertyId = (request.getParameter("property") != null) ? request.getParameter("property") : "default";
                String propertyValue = "Property value not found";

                String configFileServletContextPath = getServletContext().getRealPath("/WEB-INF/classes/default/config.properties");
                String configFilePath = (request.getParameter("configFilePath") != null) ? request.getParameter("configFilePath") : configFileServletContextPath;

                if (configFilePath == configFileServletContextPath) {
                    ReadProperties.setPropertiesFile(configFileServletContextPath);
                }

                if (propertyId != "default") {
                    propertyId = propertyId.trim();
                    propertyValue = ReadProperties.getPropertyValue(propertyId);
                }

                jsonObject = ResponseObjectSetup.getJSONResponseObjectTemplate();
                jsonObjectData = new JSONObject();
                jsonObjectData.put(configFilePath, propertyValue);

                /* jsonObject.append("data", jsonObjectData); */
                jsonObject.put("data", jsonObjectData);

                response.getWriter().write(JSONObject.valueToString(jsonObject));
                response.getWriter().flush();
                response.getWriter().close();
        
    }
    
}

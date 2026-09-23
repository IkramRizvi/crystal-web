package com.sandc.crystal.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandc.crystal.base.util.ReadProperties;

public class TestProperty extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("The value of " + propertyId + " is: " + propertyValue);
        response.getWriter().write("\nThe config file path is: " + configFilePath);
        response.getWriter().flush();
        response.getWriter().close();
        
    }
    
}

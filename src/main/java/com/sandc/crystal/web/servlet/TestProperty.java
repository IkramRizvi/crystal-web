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
                if (propertyId != "default") {
                    propertyId = propertyId.trim();
                    propertyValue = ReadProperties.getPropertyValue(propertyId);
                }

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("The value of " + propertyId + " is: " + propertyValue);
    }
    
}

package com.sandc.crystal.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandc.crystal.base.model.Object;
import com.sandc.crystal.base.trans.RetrieveObject;

public class ReadObject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("application/json;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // Add your logic here to retrieve the object and write it to the response
        RetrieveObject retrieveObject = new RetrieveObject();
        Object object = retrieveObject.getObject("786");

        // Write the object to the response (example using a JSON library like Gson or Jackson)
        response.getWriter().write(object.toString()); // Replace with actual serialization logic
        
    }
    
}

package com.sandc.crystal.web.servlet.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestContents extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /*
        response.setContentType("application/json");
         */
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println(
            "<HTML><head><title>Test Contents</title></head><body bgcolor=\"#FF5732\">"
            + "<h1 align='center'>Display Header Request</h1>"
            + "<b>Request Method:</b> " + request.getMethod() + "<br>"
            + "<b>Request URI:</b> " + request.getRequestURI() + "<br>"
            + "<b>Request Protocol:</b> " + request.getProtocol() + "<br><br>"
            + "<table border='1' align='center'>"
            + "<tr bgcolor=\"#FFAD00\">"
            + "<th>Header Name</th><th>Header Value</th>"
        );

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<tr><td>" + headerName + "</td>");
            out.println("<td>" + request.getHeader(headerName) + "</td></tr>");
        }

        out.println("</table></body></html>");

        /* 
        response.getWriter().write(JSONObject.valueToString(jsonObject));
        response.getWriter().flush();
        response.getWriter().close();
         */

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        StringBuilder requestBody = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                requestBody.append(line).append("\n");
            }
        }

        // Printing request body (for demonstration)
        
        response.setContentType("text/plain");
        response.getWriter().write("Received POST body: \n" + requestBody.toString());
        response.getWriter().write("Received successfully");
   }
    
}

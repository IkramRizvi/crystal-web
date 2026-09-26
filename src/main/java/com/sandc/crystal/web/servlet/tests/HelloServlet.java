package com.sandc.crystal.web.servlet.tests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandc.crystal.base.test.Test1;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number1 = Integer.parseInt((request.getParameter("number1") == null) ? "0" : request.getParameter("number1"));
        int number2 = Integer.parseInt((request.getParameter("number2") == null) ? "0" : request.getParameter("number2"));
        Test1 test1 = new Test1();
        int sum = test1.add(number1, number2);
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter()
                .write("Hello from Crystal Web. HelloServlet in com.sandc.crystal.web.servlet is working fine.");
        response.getWriter().write(
                "com.sandc.crystal.base.test.Test1.add(" + number1 + ", " + number2 + ") = " + Integer.toString(sum));
    }
}
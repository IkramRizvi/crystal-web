package com.sandc.crystal.web.servlet.tests;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        logger.info("Test servlet accessed");
        response.setContentType("text/plain;charset=UTF-8");

        /* Make Context, get Connection, get PreparedStatement, get ResultSet */
        try {
            String statement = "SELECT id, name FROM object where id = ?";
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:/CrystalDS");
            logger.info("DataSource obtained: " + dataSource.toString());
            
            Connection connection = dataSource.getConnection();
            logger.info("Connection obtained: " + connection.toString());

            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, "786");
            logger.info("PreparedStatement created: " + preparedStatement.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("ResultSet obtained: " + resultSet.toString());

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                response.getWriter().println("Object ID: " + id + ", Name: " + name);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

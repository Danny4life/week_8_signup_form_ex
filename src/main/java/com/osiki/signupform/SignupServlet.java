package com.osiki.signupform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "signupServlet", value = "/signup-servlet")
public class SignupServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "PASSword1234!#";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try{
            // add mysql connector dependency to POM.XML
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)){
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (firstName, lastName, email, password) VALUES (?, ?, ?, ?)");
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, password);

                int rowAffected = statement.executeUpdate();

                if(rowAffected > 0){
//                    resp.sendRedirect("signup-success.jsp");
                    resp.sendRedirect("signup-success.jsp");
                }else {
                    resp.sendRedirect("signup-error.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("signup-error.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("signup-error.jsp");
        }

    }
}

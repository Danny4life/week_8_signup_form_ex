package com.osiki.signupform.controller;

import com.osiki.signupform.dao.UserDao;
import com.osiki.signupform.model.UserSignup;
import com.osiki.signupform.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "user", value = "/signup")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserSignup user = new UserSignup(firstName, lastName, email, password);
        UserDao userDao = new UserDao(ConnectionUtil.getConnection());
        userDao.addUser(user);

        // Redirect to a success page or display a message
        response.sendRedirect("signup-success.jsp");
    }
}

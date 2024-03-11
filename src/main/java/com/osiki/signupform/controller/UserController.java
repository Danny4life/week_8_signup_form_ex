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
//    private static final long serialVersionUID = 1L;
//    private UserDao userDao;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        userDao = new UserDao(url, username, password);
//    }

//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        if(action != null){
//            switch (action) {
//                case "/signup":
//                    try {
//                        addUser(req, resp);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
//                default:
//                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
//
//            }
//
//        }
//
//    }

//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        String action = req.getServletPath();
//
//        try{
//            switch (action) {
//                case "/add":
//                    addUser(req, resp);
//                    break;
//                default:
//                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
//                    break;
//
//            }
//        } catch (IOException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        UserSignup newUser = new UserSignup(firstName, lastName, email, password);
//        userDao.addUser(newUser);
//
//        resp.sendRedirect("signup-success.jsp");
//    }


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

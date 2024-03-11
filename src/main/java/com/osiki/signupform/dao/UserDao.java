package com.osiki.signupform.dao;

import com.osiki.signupform.model.UserSignup;
import com.osiki.signupform.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

//    private String JDBC_URL = "jdbc:mysql://localhost:3306/userDB";
//    private String JDBC_USER = "root";
//    private String JDBC_PASSWORD =  "PASSword1234!#";
//
//    private Connection connection;
//
//    public UserDao(String JDBC_URL, String JDBC_USER, String JDBC_PASSWORD) {
//        this.JDBC_URL = JDBC_URL;
//        this.JDBC_USER = JDBC_USER;
//        this.JDBC_PASSWORD = JDBC_PASSWORD;
//    }
//
//    public UserDao() {
//    }
//
//    public void connect() throws SQLException {
//        if(connection == null || connection.isClosed()){
//
//            try{
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//        }
//
//    }
//
//    public void disConnect() throws SQLException{
//        if(connection != null && !connection.isClosed()){
//            connection.close();
//        }
//
//    }
//
//    public boolean addUser(UserSignup user) throws SQLException {
//        String sql = "INSERT INTO user (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
//        connect();
//
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, user.getFirstName());
//        statement.setString(2, user.getLastName());
//        statement.setString(3, user.getEmail());
//        statement.setString(4, user.getPassword());
//
//        boolean rowInserted = statement.executeUpdate() > 0;
//        statement.close();
//        disConnect();
//
//        return rowInserted;
//
//    }

    private Connection connection;


    public UserDao(Connection connection) {
        this.connection = ConnectionUtil.getConnection();
    }

    public void addUser(UserSignup user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (firstName, lastName, email, password) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

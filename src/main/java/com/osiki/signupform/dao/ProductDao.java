package com.osiki.signupform.dao;

import com.osiki.signupform.model.Product;
import com.osiki.signupform.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = ConnectionUtil.getConnection();
    }

    public void addProducts(Product product){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (name, price) VALUES (?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

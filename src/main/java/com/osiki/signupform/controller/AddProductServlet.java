package com.osiki.signupform.controller;

import com.osiki.signupform.dao.ProductDao;
import com.osiki.signupform.model.Product;
import com.osiki.signupform.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addProductToServlet", value = "/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        productDao.addProducts(product);

        response.sendRedirect("/");
    }
}

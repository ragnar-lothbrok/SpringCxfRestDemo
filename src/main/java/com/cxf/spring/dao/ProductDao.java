package com.cxf.spring.dao;

import com.cxf.spring.model.Product;

public class ProductDao {

    public Product getProduct(String id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Vikings");
        product.setType("Serial");
        //Fetch from DB
        return product;
    }

    public Product saveProduct(Product product) {
        // Perform some DB Operation
        product.setId("456");
        return product;
    }

}

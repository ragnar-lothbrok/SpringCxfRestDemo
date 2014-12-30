package com.cxf.spring.services.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.spring.dao.ProductDao;
import com.cxf.spring.model.Product;
import com.cxf.spring.services.ProductService;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao prodcutDao;

    public Response getProduct(String id) {
        System.out.println("product id=" + id);
        Product product = prodcutDao.getProduct(id);
        return  Response.status(200).entity(product.XmlFormat()).build();
    }

    public Product saveProduct(Product product) {
        return prodcutDao.saveProduct(product);
    }

}

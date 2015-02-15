package com.cxf.spring.services.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.spring.dao.CustomerDAO;
import com.cxf.spring.model.Customer;
import com.cxf.spring.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Response getCustomer(Integer customerId) {
        try {
            return Response.status(Response.Status.ACCEPTED).entity(customerDAO.selectCustomerById(customerId).toXML())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @Override
    public Response getAllCustomer() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Response.status(Response.Status.ACCEPTED)
                    .entity(mapper.defaultPrettyPrintingWriter().writeValueAsString(customerDAO.selectAllCustomers()))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

    @Override
    public Response saveCustomer(Customer customer) {
        customerDAO.insertCustomer(customer);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Response.status(Response.Status.ACCEPTED)
                    .entity(mapper.defaultPrettyPrintingWriter().writeValueAsString(customer)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

}

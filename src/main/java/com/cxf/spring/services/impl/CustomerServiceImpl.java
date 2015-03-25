package com.cxf.spring.services.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.spring.dao.CustomerDAO;
import com.cxf.spring.model.Customer;
import com.cxf.spring.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    
    static Logger log = Logger.getLogger(
            CustomerServiceImpl.class.getName());

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
            log.debug("getAllCustomer.........");
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

    //Input json : [1,2,3,4,5]
    @Override
    public Response getCustomersByIds(List<Long> customerIds) {
        log.error("customerIds : "+customerIds);
        try {
            return Response.status(Response.Status.ACCEPTED).entity("<customer><ids>"+customerIds+"</ids></customer>")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Status.BAD_REQUEST).build();
    }

}

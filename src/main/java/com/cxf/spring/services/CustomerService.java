package com.cxf.spring.services;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cxf.spring.model.Customer;

@WebService(serviceName = "customerServices")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface CustomerService {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    @Path("/customer/{id}")
    public Response getCustomer(@PathParam("id") Integer id);

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/customer")
    public Response getAllCustomer();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/product")
    public Response saveCustomer(Customer customer);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML })
    @Path("/product/customers")
    public Response getCustomersByIds(List<Long> customerIds);

}

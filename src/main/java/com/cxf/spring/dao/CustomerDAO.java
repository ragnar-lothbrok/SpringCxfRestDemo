    package com.cxf.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cxf.spring.model.Customer;

public interface CustomerDAO {
    
    String GET_CUSTOMERS = "SELECT customerId as customerId, firstName  as firstName,  lastName   as lastName, mobileNo   as mobileNo FROM Customer";
	
    @Select(GET_CUSTOMERS)
	public List<Customer> selectAllCustomers();

    String GET_CUSTOMER_BY_ID = "SELECT c.customerId, c.firstName, c.lastName,c.mobileNo FROM Customer c WHERE c.customerId=#{customerId}";
    
    @Select(GET_CUSTOMER_BY_ID)
	public Customer selectCustomerById(@Param("customerId")int customerId);

    String ADD_CUSTOMER = "INSERT INTO Customer (firstName, lastName, mobileNo) VALUES (#{firstName}, #{lastName}, #{mobileNo})";
    
    @Insert(ADD_CUSTOMER)
	public void insertCustomer(@Param("customer") Customer customer);
	
    String UPDATE_CUSTOMER = "UPDATE Customer SET firstName = #{firstName}, lastName = #{lastName}, mobileNo = #{mobileNo} WHERE customerId = #{customerId}";
    
    @Update(UPDATE_CUSTOMER)
	public void updateCustomer(@Param("customer") Customer customer);

    String DELETE_CUSTOMER = "DELETE from Customer WHERE customerId = #{customerId}";
    
    @Delete(DELETE_CUSTOMER)
	public void deleteCustomer(@Param("customerId") int customerId);
}

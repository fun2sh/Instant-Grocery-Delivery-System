package com.InstantGrocery.dao;

import com.InstantGrocery.model.Customer;

import java.util.List;

public interface CustomerDao {


    Customer getCustomerByUsername(String userName);

    List<Customer> getCustomerByName(String customerName);

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
    void editCustomer(Customer customer);

}

package com.InstantGrocery.dao;

import com.InstantGrocery.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    CustomerOrder getOrderById(CustomerOrder id);
//    List<CustomerOrder> getOrderByUsername(String userName);
    List<CustomerOrder> getAllOrders();
    void editCustomerOrder(CustomerOrder customerOrder);

}

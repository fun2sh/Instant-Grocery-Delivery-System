package com.InstantGrocery.dao.impl;

import com.InstantGrocery.dao.CustomerDao;
import com.InstantGrocery.model.Customer;
import com.InstantGrocery.model.CustomerAddress;
import com.InstantGrocery.model.PaymentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getCustomerShippingAddress().setCustomer(customer);
        customer.getPaymentDetails().setCustomer(customer);
        customer.setAccountType("CUSTOMER");

        session.saveOrUpdate(customer.getCustomerShippingAddress());
        session.saveOrUpdate(customer.getPaymentDetails());


 /*       Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);*/

        session.saveOrUpdate(customer);
        //session.saveOrUpdate(newCart);

        session.flush();
    }

    @Override
    public void editCustomer(Customer customer){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
    }

    @Override
    public Customer getCustomerByUsername(String userName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer as customer where customer.userName = :userName");
        query.setParameter("userName", userName);
        session.flush();

        return (Customer) query.uniqueResult();
    }

    @Override
    public List<Customer> getCustomerByName(String customerName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer as customer where customer.customerName = :name");
        query.setParameter("name", customerName);
        List<Customer> customerList = query.list();
        session.flush();

        return customerList ;
    }

    @Override
    public List<Customer> getAllCustomers() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        session.flush();

        return customerList;
    }
}

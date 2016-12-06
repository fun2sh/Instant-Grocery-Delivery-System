package com.InstantGrocery.dao.impl;
import com.InstantGrocery.dao.CartDao;
import com.InstantGrocery.dao.CustomerOrderDao;
import com.InstantGrocery.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    //@Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    @Override
    public List<CustomerOrder> getAllOrders(){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder ");
        List<CustomerOrder> orderList = query.list();
        session.flush();

        return orderList;

    }
    @Override
    public CustomerOrder getOrderById(CustomerOrder id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerOrder customerOrder = (CustomerOrder) session.get(CustomerOrder.class, id);
        session.flush();

        return customerOrder;
    }

    @Override
    public void editCustomerOrder(CustomerOrder customerOrder){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

}







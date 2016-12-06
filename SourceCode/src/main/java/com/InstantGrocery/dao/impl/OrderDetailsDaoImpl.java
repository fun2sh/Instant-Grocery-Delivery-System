package com.InstantGrocery.dao.impl;


import com.InstantGrocery.dao.CartDao;
import com.InstantGrocery.model.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDetailsDaoImpl implements CartDao.OrderDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrderDetails(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderDetails);
        session.flush();
    }

    @Override
    public void editCartProduct(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderDetails);
        session.flush();
    }

    @Override
    public OrderDetails getOrderDetailsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderDetails orderDetails = (OrderDetails) session.get(OrderDetails.class, id);
        session.flush();

        return orderDetails;
    }

}

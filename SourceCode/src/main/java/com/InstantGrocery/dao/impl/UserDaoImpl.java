package com.InstantGrocery.dao.impl;

import com.InstantGrocery.dao.UserDao;
import com.InstantGrocery.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void editUser(User user){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();
    }

    @Override
    public User getUserByUsername(String userName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User as u where u.userName = :userName");
        query.setParameter("userName", userName);
        session.flush();

        return (User) query.uniqueResult() ;
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();
        session.flush();

        return userList;
    }
}

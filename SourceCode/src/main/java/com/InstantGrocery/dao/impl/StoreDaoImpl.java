package com.InstantGrocery.dao.impl;

import com.InstantGrocery.dao.StoreDao;
import com.InstantGrocery.model.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StoreDaoImpl implements StoreDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStore(Store store) {
        Session session = sessionFactory.getCurrentSession();

        store.getStoreAddress().setStore(store);
        store.setAccountType("STORE");

        session.saveOrUpdate(store.getStoreAddress());
        session.saveOrUpdate(store);

        session.flush();
    }

    @Override
    public void editStore(Store store){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(store);
        session.flush();
    }

    @Override
    public Store getStoreByUsername(String userName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Store where userName = :userName");
        query.setParameter("userName", userName);
        session.flush();

        return (Store) query.uniqueResult();
    }

    @Override
    public List<Store> getStoreByName(String storeName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Store where storeName = :name");
        query.setParameter("name", storeName);
        List<Store> storeList = query.list();
        session.flush();

        return storeList ;
    }

    @Override
    public List<Store> getStoreByCity(String city) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Store where storeName = :city");
        query.setParameter("name", city);
        List<Store> storeList = query.list();
        session.flush();

        return storeList ;
    }


    @Override
    public List<Store> getAllStores() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Store");
        List<Store> storeList = query.list();
        session.flush();

        return storeList;
    }
}

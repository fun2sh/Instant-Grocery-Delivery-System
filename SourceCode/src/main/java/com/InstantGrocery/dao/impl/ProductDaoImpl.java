package com.InstantGrocery.dao.impl;


import com.InstantGrocery.dao.ProductDao;
import com.InstantGrocery.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(int productId) {

        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, productId);
        session.flush();

        return product;
    }

    @Override
    public List<Product> getProductByName(String productName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productName = :productName");
        query.setParameter("productName", productName);
        List<Product> productList = query.list();
        session.flush();

        return productList ;
    }

    @Override
    public List<Product> getProductByCity(String city) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select product" +
                "from Product as product, Store as store, StoreAddress as storeAddress " +
                "where storeAddress.city = :city and store.userId");
        query.setParameter("city", city);
        List<Product> ProductList = query.list();
        session.flush();

        return ProductList ;
    }

    @Override
    public List<Product> getProductByStore(String userName) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select product from User as user, Product as product where user.userName = :userName");
        query.setParameter("userName", userName);
        List<Product> ProductList = query.list();
        session.flush();

        return ProductList ;
    }

    @Override
    public List<Product> getAllProducts() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    @Override
    public void deleteProduct(Product product){

        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();

    }

}


package com.InstantGrocery.dao.impl;

import com.InstantGrocery.dao.ProductCategoryDao;
import com.InstantGrocery.model.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCategory(ProductCategory category) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        session.flush();

    }

    @Override
    public void editCategory(ProductCategory category){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        session.flush();
    }

    @Override
    public void deleteCategory(ProductCategory category){

        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
        session.flush();

    }

    @Override
    public ProductCategory getCategoryByName(String name) {

        Session session = sessionFactory.getCurrentSession();
        ProductCategory category = (ProductCategory) session.get(ProductCategory.class, name);
        session.flush();

        return category;
    }

    @Override
    public List<ProductCategory> getAllCategory() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ProductCategory");
        List<ProductCategory> categoryList = query.list();
        session.flush();

        return categoryList;
    }

}

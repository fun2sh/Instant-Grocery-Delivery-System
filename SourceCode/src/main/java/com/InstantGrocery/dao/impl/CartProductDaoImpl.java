package com.InstantGrocery.dao.impl;


import com.InstantGrocery.dao.CartProductDao;
import com.InstantGrocery.model.Cart;
import com.InstantGrocery.model.CartProduct;
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
public class CartProductDaoImpl implements CartProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCartProduct(CartProduct cartProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartProduct);
        session.flush();
    }

    @Override
    public void editCartProduct(CartProduct cartProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartProduct);
        session.flush();
    }

    @Override
    public void removeCartProduct(CartProduct cartProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartProduct);
        session.flush();
    }

    @Override
    public void removeAllCartProduct(Cart cart) {
        List<CartProduct> cartProduct = cart.getCartProductList();

        for (CartProduct item: cartProduct) {
            removeCartProduct(item);
        }
    }

    @Override
    public CartProduct getCartProductById(int cartProductId){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartProduct where cartProductId = :cartProductId");
        query.setParameter("cartProductId", cartProductId);
        session.flush();

        return (CartProduct) query.uniqueResult();
    }

    @Override
    public CartProduct getCartProductByProductId(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartProduct where product.productId = :productId");
        query.setParameter("productId", productId);
        Product product = (Product) query.uniqueResult();

        session.flush();

        return (CartProduct) query.uniqueResult();
    }

    @Override
    public List<CartProduct> getCartProductByCartId(int cartId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where cartId= :cartId");
        query.setParameter("cartId", cartId);

        Cart cart = (Cart) query.uniqueResult();
        session.flush();

        return cart.getCartProductList();
    }

}

package com.InstantGrocery.dao.impl;


import com.InstantGrocery.dao.CartDao;
import com.InstantGrocery.dao.CartProductDao;
import com.InstantGrocery.dao.CustomerOrderDao;
import com.InstantGrocery.model.Cart;
import com.InstantGrocery.model.CartProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CartProductDao cartProductDao;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    @Override
    public void updateCart(Cart cart) {

        Session session = sessionFactory.getCurrentSession();

        int cartId = cart.getCartId();
        List<CartProduct> cartProductList = cartProductDao.getCartProductByCartId(cartId);

        double cartTotal = 0;
        for(CartProduct item: cartProductList){
            cartTotal += item.getTotalPrice();
        }

        cart.setCartTotal(cartTotal);
        session.saveOrUpdate(cart);
    }
}

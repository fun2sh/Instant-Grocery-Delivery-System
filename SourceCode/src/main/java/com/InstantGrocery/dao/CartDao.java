package com.InstantGrocery.dao;
import com.InstantGrocery.model.Cart;
import com.InstantGrocery.model.OrderDetails;

public interface CartDao {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);

    interface OrderDetailsDao {

        void addOrderDetails(OrderDetails orderDetails);
        void editCartProduct(OrderDetails orderDetails);
        OrderDetails getOrderDetailsById(int id);
    }
}

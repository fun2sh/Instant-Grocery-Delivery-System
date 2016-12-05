package com.InstantGrocery.dao;

import com.InstantGrocery.model.Cart;
import com.InstantGrocery.model.CartProduct;

import java.util.List;

public interface CartProductDao {

    void addCartProduct(CartProduct cartItem);

    void editCartProduct(CartProduct cartItem);
    void removeCartProduct(CartProduct cartItem);

    void removeAllCartProduct(Cart cart);
    CartProduct getCartProductById(int cartProductId);
    CartProduct getCartProductByProductId(int productId);

    List<CartProduct> getCartProductByCartId(int cartId);

}

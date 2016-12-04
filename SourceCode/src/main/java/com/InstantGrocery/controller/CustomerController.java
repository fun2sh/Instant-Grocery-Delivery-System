package com.InstantGrocery.controller;

import com.InstantGrocery.dao.*;
import com.InstantGrocery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartProductDao cartProductDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartDao.OrderDetailsDao orderDetailsDao;

    @RequestMapping("/cart/view")
    public String getCustomerCart(Model model){


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerDao.getCustomerByUsername(auth.getName());
        int cartId = customer.getCart().getCartId();
        List<CartProduct> cartItemList = cartProductDao.getCartProductByCartId(cartId);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("cartId", cartId);

        return "cart-details";
    }

    @RequestMapping("/cart/add/{productId}")
    public String addItemsToCart(@PathVariable int productId){

        Product product = productDao.getProductById(productId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerDao.getCustomerByUsername(auth.getName());

        Cart cart = customer.getCart();
        List<CartProduct> cartItemList = cart.getCartProductList();

        for(CartProduct item : cartItemList){

            if (product.getProductId() == item.getProduct().getProductId()) {

                item.setQuantity(item.getQuantity() + 1);
                item.setTotalPrice(product.getProductPrice() * item.getQuantity());
                cartProductDao.editCartProduct(item);
                return "redirect:/customer/cart/view";

            }
        }

        //else


        CartProduct item = new CartProduct();
        item.setProduct(product);
        item.setQuantity(1);
        item.setTotalPrice(product.getProductPrice() * item.getQuantity());
        item.setCart(cart);
        cartProductDao.addCartProduct(item);
        //cartDao.updateCart(cart);

        return "redirect:/customer/cart/view";

    }


    @RequestMapping("/cart/remove/{cartProductId}")
    public String removeCartProduct(@PathVariable int cartProductId) {

        CartProduct item = cartProductDao.getCartProductById(cartProductId);
        cartProductDao.removeCartProduct(item);

        return "redirect:/customer/cart/view";
    }

    @RequestMapping(value = "/order/proceed")
    public String getCartId() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerDao.getCustomerByUsername(auth.getName());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/order/proceed/" + cartId;
    }

    @RequestMapping("/order/proceed/{cartId}")
    public String displayOrderDetails(@PathVariable int cartId, Model model) {

        Cart cart = cartDao.getCartById(cartId);
        List<CartProduct> orderedItems = cart.getCartProductList();

        PaymentDetails paymentDetails = cart.getCustomer().getPaymentDetails();
        CustomerAddress shippingAddress = cart.getCustomer().getCustomerShippingAddress();

        model.addAttribute("orderedItems", orderedItems);
        model.addAttribute("paymentDetails", paymentDetails);
        model.addAttribute("shippingAddress", shippingAddress);
        model.addAttribute("cartId", cartId);

        return "order-confirmation";
    }

   @RequestMapping("/order/confirm/{cartId}")
   public String placeOrder(@PathVariable int cartId) {

       Cart cart = cartDao.getCartById(cartId);
       List<CartProduct> orderedItems = cart.getCartProductList();
       if (orderedItems.size() == 0){
           return "redirect:/";
       }

       List<CartProduct> cartItemList = cart.getCartProductList();
       for(CartProduct item : cartItemList){

           cartProductDao.removeCartProduct(item);
       }
       /*
       CustomerOrder customerOrder = new CustomerOrder();
       customerOrder.setCustomer(cart.getCustomer());

       DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
       Date currentDate = new Date();
       Calendar c = Calendar.getInstance();
       c.setTime(currentDate);
       customerOrder.setOrderDate(dateFormat.format(c.getTime()));

       c.add(Calendar.DATE, 1);
       customerOrder.setEstimatedDeliveryDate(dateFormat.format(c.getTime()));
       customerOrder.setOrderTotal(cart.getCartTotal());

       List<OrderDetails> orderDetailsList = customerOrder.getOrderDetailsList();

       customerOrderDao.addCustomerOrder(customerOrder);

       customerOrder.setOrderDetailsList(orderDetailsList);

       List<CartProduct> cartItemList = cart.getCartProductList();

       for(CartProduct item : cartItemList){

           OrderDetails orderDetails = new OrderDetails();
           orderDetails.setCustomerOrder(customerOrder);
           orderDetails.setProduct(item.getProduct());
           orderDetails.setQuantity(item.getQuantity());
           orderDetails.setTotalPrice(item.getTotalPrice());
           orderDetailsDao.addOrderDetails(orderDetails);
           cartProductDao.removeCartProduct(item);

       }

       customerOrderDao.addCustomerOrder(customerOrder);
       cartDao.updateCart(cart);

        */

       return "order-confirmed";
   }


}

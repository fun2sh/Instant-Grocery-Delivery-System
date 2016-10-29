package com.InstantGrocery.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = -3626075377531359003L;

    @NotEmpty(message = "The customer name must entered!")
    private String customerName;

    @Email
    @NotEmpty(message = "The customer email must entered!")
    private String customerEmail;

    @NotEmpty(message = "The customer phone number must entered!")
    private String customerPhone;

    private String birthDate;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private PaymentDetails paymentDetails;

    @OneToOne
    @JoinColumn(name = "addressId")
    private CustomerAddress customerShippingAddress;

/*    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Order order;*/

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerAddress getCustomerShippingAddress() {
        return customerShippingAddress;
    }

    public void setCustomerShippingAddress(CustomerAddress customerShippingAddress) {
        this.customerShippingAddress = customerShippingAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getBirthDate() {
        return birthDate;
    }


/*    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}

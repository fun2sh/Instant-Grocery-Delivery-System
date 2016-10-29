package com.InstantGrocery.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class PaymentDetails implements Serializable {

    private static final long serialVersionUID = 5619305516916175508L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardId;

    @NotEmpty(message = "Name must be entered!")
    private String cardName;

    @NotNull(message = "Card number must be entered!")
    //@Digits(integer=16, fraction = 0, message = "Please enter 16 digits")
    private long cardNumber;

    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private String expiryDate;

    @NotNull(message = "CVV must be entered!")
    private short cvv;

    @OneToOne
    private Customer customer;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }



}

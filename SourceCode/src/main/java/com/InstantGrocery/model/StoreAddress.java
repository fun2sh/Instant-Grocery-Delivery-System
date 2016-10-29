package com.InstantGrocery.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class StoreAddress implements Serializable {


    private static final long serialVersionUID = -4946738568395685345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @NotEmpty(message = "Address Line 1 must be entered!")
    private String addressLine1;
    private String addressLine2;

    @NotEmpty(message = "City must be entered!")
    private String city;

    @NotEmpty(message = "State must be entered!")
    private String state;

    @NotEmpty(message = "Country must be entered!")
    private String country;

    @NotNull(message = "Zipcode must be entered!")
    //@Size(min = 6, max = 6)
    private int zipcode;


    @OneToOne
    private Store store;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

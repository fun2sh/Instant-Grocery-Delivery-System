package com.InstantGrocery.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="userId")
public class Store extends User implements Serializable {

    private static final long serialVersionUID = 6994612035595101185L;

    @NotEmpty(message = "Store name must be entred!")
    private String storeName;

    @NotEmpty(message = "Manager name must be entred!")
    private String managerName;

    @Email
    @NotEmpty(message = "Email must entered!")
    private String managerEmail;

    @NotNull(message = "Phone number must entered!")
    private int storePhone;

    @OneToOne
    @JoinColumn(name = "addressId")
    private StoreAddress storeAddress;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public int getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(int storePhone) {
        this.storePhone = storePhone;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(StoreAddress storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

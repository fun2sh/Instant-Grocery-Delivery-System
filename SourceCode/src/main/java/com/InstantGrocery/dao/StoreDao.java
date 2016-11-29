package com.InstantGrocery.dao;


import com.InstantGrocery.model.Store;

import java.util.List;

public interface StoreDao {

    Store getStoreByUsername(String userName);

    List<Store> getStoreByName(String storeName);
    List<Store> getStoreByCity(String city);
    List<Store> getAllStores();

    void addStore(Store store);
    void editStore(Store store);

}

package com.InstantGrocery.dao;

import com.InstantGrocery.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(int productId);

    List<Product> getProductByName(String productName);
    List<Product> getProductByStore(String userName);
    List<Product> getProductByCity(String city);
    List<Product> getAllProducts();

    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
}

package com.InstantGrocery.dao;


import com.InstantGrocery.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    void addCategory(ProductCategory category);

    ProductCategory getCategoryByName(String name);

    List<ProductCategory> getAllCategory();

    void editCategory(ProductCategory category);
    void deleteCategory(ProductCategory category);

}

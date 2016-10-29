package com.InstantGrocery.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ProductCategory implements Serializable{

    private static final long serialVersionUID = 5021286630376329571L;

    @Id
    @NotEmpty (message = "Category name must be given")
    private String categoryName;

    @NotEmpty (message = "Category description must be given")
    private String categoryDesc;

    @Transient
    private MultipartFile categoryImage;

    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> productList;
    */

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName.toUpperCase();
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public MultipartFile getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(MultipartFile categoryImage) {
        this.categoryImage = categoryImage;
    }
}

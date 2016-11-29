package com.InstantGrocery.controller;

import com.InstantGrocery.dao.ProductCategoryDao;
import com.InstantGrocery.dao.ProductDao;
import com.InstantGrocery.dao.StoreDao;
import com.InstantGrocery.model.Product;
import com.InstantGrocery.model.ProductCategory;
import com.InstantGrocery.model.Store;
import com.InstantGrocery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private ProductCategoryDao categoryDao;

    @RequestMapping("/product/productList")
    public String getProducts(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            List<Product> product = productDao.getProductByStore(auth.getName());
            model.addAttribute("productlist", product);
        }
        return "store-product-list";
    }


    @RequestMapping("/product/view-product/{productId}")
    public String getProductById(Model model, @PathVariable int productId) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute("product", product);
        return "product-details";
    }



    @RequestMapping(value = "/product/add-product")
    public String addProduct(Model model){

        Product product = new Product();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            com.InstantGrocery.model.User userDetails = (com.InstantGrocery.model.User) auth.getPrincipal();
            Store store = storeDao.getStoreByUsername(userDetails.getUserName());

            product.setStore(store);
            store.getProductList().add(product);

            List<ProductCategory> categorylist = categoryDao.getAllCategory();

            List<String> categoryNameList = new ArrayList<>();
            for (ProductCategory aCategory: categorylist) {
                categoryNameList.add(aCategory.getCategoryName());

            }
            model.addAttribute("product", product);
            model.addAttribute("categorylist",categoryNameList);

        }

        return "add-product";
    }

    @RequestMapping(value = "/product/add-product", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "add-product";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            com.InstantGrocery.model.User userDetails = (com.InstantGrocery.model.User) auth.getPrincipal();
            Store store = storeDao.getStoreByUsername(userDetails.getUserName());

            product.setStore(store);
            store.getProductList().add(product);
        }

        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductName() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/store/product/productList";
    }


    @RequestMapping("/product/edit-product/{productId}")
    public String editproduct(@PathVariable int productId, Model model) {
        Product product = productDao.getProductById(productId);
        productDao.editProduct(product);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @RequestMapping(value = "/product/edit-product", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product,
                                  BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "edit-product";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductName() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Image saving failed.", e);
            }
        }

        productDao.editProduct(product);

        return "redirect:/store/product/productList";
    }

    @RequestMapping("/product/delete-product/{productId}")
    public String deleteproduct(@PathVariable int productId, HttpServletRequest request) {

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productDao.getProductById(productId);
        productDao.deleteProduct(product);

        return "redirect:/store/product/productList";
    }

}

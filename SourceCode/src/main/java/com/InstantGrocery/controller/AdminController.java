package com.InstantGrocery.controller;

import com.InstantGrocery.dao.ProductCategoryDao;
import com.InstantGrocery.dao.UserDao;
import com.InstantGrocery.model.Product;
import com.InstantGrocery.model.ProductCategory;
import com.InstantGrocery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Path path;

    @Autowired
    private ProductCategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/category/category-list")
    public String getCategories(Model model){
        List<ProductCategory> categories = categoryDao.getAllCategory();
        model.addAttribute("categorylist",categories);
        return "category-list";
    }

    /*
    @RequestMapping("/category/view-category/{categoryName}")
    public String getCategoryByName(Model model, @PathVariable String categoryName) throws IOException {
        ProductCategory category = categoryDao.getCategoryByName(categoryName);
        model.addAttribute("category", category);
        return "categorydetails";
    }
    */


    @RequestMapping(value = "/category/add-category")
    public String addCategory(Model model){
        ProductCategory category = new ProductCategory();
        model.addAttribute("category", category);
        return "add-category";
    }

    @RequestMapping(value = "/category/add-category", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("category") ProductCategory category,
                                 BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "add-category";
        }

        categoryDao.addCategory(category);

        MultipartFile categoryImage = category.getCategoryImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + category.getCategoryName() + ".png");

        if (categoryImage != null && !categoryImage.isEmpty()) {
            try {
                categoryImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/admin/category/category-list";
    }


    @RequestMapping("/category/edit-category/{categoryName}")
    public String editCategory(@PathVariable String categoryName, Model model) {
        ProductCategory category = categoryDao.getCategoryByName(categoryName);
        categoryDao.editCategory(category);
        model.addAttribute("category", category);
        return "edit-category";
    }

    @RequestMapping(value = "/category/edit-category", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("category") ProductCategory category,
                                  BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "edit-category";
        }

        MultipartFile categoryImage = category.getCategoryImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + category.getCategoryName() + ".png");

        if (categoryImage != null && !categoryImage.isEmpty()) {
            try {
                categoryImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Image saving failed.", e);
            }
        }

        categoryDao.editCategory(category);

        return "redirect:/admin/category/category-list";
    }

    @RequestMapping("/category/delete-category/{categoryName}")
    public String deleteCategory(@PathVariable String categoryName, HttpServletRequest request) {

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + categoryName + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ProductCategory category = categoryDao.getCategoryByName(categoryName);
        categoryDao.deleteCategory(category);

        return "redirect:/admin/category/category-list";
    }

    @RequestMapping("/user/user-list")
    public String getUsers(Model model){
        List<User> user = userDao.getAllUsers();
        model.addAttribute("userlist",user);
        return "user-list";
    }

    @RequestMapping("/user/view-user/{userName}")
    public String getUserByUsername(Model model, @PathVariable String userName) throws IOException {
        User user = userDao.getUserByUsername(userName);
        model.addAttribute("user", user);
        return "user-details";
    }
}

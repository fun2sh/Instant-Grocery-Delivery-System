package com.InstantGrocery.controller;

import com.InstantGrocery.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

@Controller
public class MainController {

//    @Autowired
//    private UserDao userDao;

    @RequestMapping("/")
    public String home(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            com.InstantGrocery.model.User userDetails = (com.InstantGrocery.model.User) auth.getPrincipal();

            if (userDetails.getAccountType().equals("ADMIN")){
                return "admin";
            }

            if (userDetails.getAccountType().equals("STORE")){
                return "store";
            }
        }
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("errors", "Either username or password incorrect!");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged Out Successfully!");
        }

       /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String userName = auth.getName(); //get logged in username

        //Get user details
        com.InstantGrocery.model.User userdetail = userDao.getUserByUsername(userName);
        model.addAttribute("userdetail", userdetail);*/

        return "login";
    }


    @RequestMapping("admin")
    public String admin(){
        return "admin";
    }


    @RequestMapping("/product/productList")
    public String productList(){
            return "productList";
        }
}


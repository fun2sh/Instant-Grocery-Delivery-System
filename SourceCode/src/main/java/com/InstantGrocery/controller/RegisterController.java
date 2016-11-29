package com.InstantGrocery.controller;

import com.InstantGrocery.dao.CustomerDao;
import com.InstantGrocery.dao.StoreDao;
import com.InstantGrocery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private StoreDao storeDao;

    @RequestMapping("/registercustomer")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        customer.setAccountType("CUSTOMER");
        CustomerAddress shippingAddress = new CustomerAddress();
        customer.setCustomerShippingAddress(shippingAddress);

        PaymentDetails paymentDetails = new PaymentDetails();
        customer.setPaymentDetails(paymentDetails);

        model.addAttribute("customer", customer);

        return "register-customer";
    }

    @RequestMapping(value = "/registercustomer", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "register-customer";
        }

        List<Customer> customerList = customerDao.getAllCustomers();

        for (Customer aCustomer : customerList) {
            if (customer.getCustomerEmail().equals(aCustomer.getCustomerEmail())) {
                model.addAttribute("emailErr", "Email already exists");

                return "register-customer";
            }

            if (customer.getUsername().equals(aCustomer.getUsername())) {
                model.addAttribute("usernameErr", "Username already exists");

                return "register-customer";
            }
        }

        customerDao.addCustomer(customer);

        return "register-success";
    }


    // STORE

    @RequestMapping("/registerstore")
    public String registerStore(Model model) {

        Store store = new Store();
        store.setAccountType("STORE");
        StoreAddress storeAddress = new StoreAddress();
        store.setStoreAddress(storeAddress);

        model.addAttribute("store", store);

        return "register-store";
    }

    @RequestMapping(value = "/registerstore", method = RequestMethod.POST)
    public String registerStorePost(@Valid @ModelAttribute("store") Store store,
                                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "register-store";
        }

        List<Store> storeList = storeDao.getAllStores();

        for (Store aStore : storeList) {
            if (aStore.getManagerEmail().equals(store.getManagerEmail())) {
                model.addAttribute("emailErr", "Email already exists");

                return "register-store";
            }

            if (store.getUsername().equals(aStore.getUsername())) {
                model.addAttribute("usernameErr", "Username already exists");

                return "register-store";
            }
        }

        storeDao.addStore(store);

        return "register-success";

    }
}

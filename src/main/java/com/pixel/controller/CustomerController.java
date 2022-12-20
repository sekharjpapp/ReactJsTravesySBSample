package com.pixel.controller;

import com.pixel.model.Customer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/getCustomerInfo")
    public String getCustomerForm(Model model) {
       // model.addAttribute();
        return "customer";
    }
    @PostMapping("/getCustomerInfo")
    public String processCustomerInfo(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("abc","xyz");
        return "";
    }
}

package com.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Checkout {
    @GetMapping("/checkout")
    public String showCheckout(){

        return "front-end/checkout";
    }
}

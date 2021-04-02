package com.controller.shop;

import com.model.Order;
import com.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Checkout {
    @Autowired
    ProvinceRepository provinceRepository;

    @GetMapping("/checkout")
    public String showCheckout( Model model){
        model.addAttribute("addOrder",new Order());

        model.addAttribute("provinces", provinceRepository.findAll());
        return "front-end/checkout";
    }
}

package com.controller.shop;

import com.repository.ProductRepository;
import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homepage {
    @Autowired
    ProductServiceImpl service;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("findTop4ByOrderByIdDesc", service.findTop4ByOrderByIdDesc());
        return "front-end/index";
    }
}

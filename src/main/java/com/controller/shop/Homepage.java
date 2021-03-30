package com.controller.shop;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Homepage {
    @Autowired
    ProductServiceImpl service;

    @GetMapping("/index")
    public String index(Model model){
        List<Product> top4ByOrderByIdDesc = service.findTop4ByOrderByIdDesc();
        model.addAttribute("findTop4ByOrderByIdDesc", top4ByOrderByIdDesc);
        return "front-end/index";
    }
}

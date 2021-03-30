package com.controller.shop;

import com.repository.ProductRepository;
import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Homepage {
    @Autowired
    ProductServiceImpl service;

    @GetMapping("/index")
    public String index(@PageableDefault(size = 12) Pageable pageable, Model model){
//        Pageable pageable1 =
        model.addAttribute("findTop4ByOrderByIdDesc", service.findTop4ByOrderByIdDesc());
        model.addAttribute("selectAllPage12", service.selectAll(pageable));
//        model.addAttribute("product", service.findOne(id).get());
        return "front-end/index";
    }

    @GetMapping("/product/quick-view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("quickViewProduct", service.findOne(id).get());
        return "back-end/product/product-view"; //sua duong dan
    }


}

package com.controller.shop;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;
import com.service.CategoryServiceImpl;

import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Homepage {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryServiceImpl categoryService;

    @ModelAttribute("findTop4ByOrderByIdDesc")
    public List<Product> findTop4ByOrderByIdDesc() {
        return productService.findTop4ByOrderByIdDesc();
    }

    @ModelAttribute("findTop4ByOrderByRatingDesc")
    public List<Product> findTop4ByOrderByRatingDesc() {
        return productService.findTop4ByOrderByRatingDesc();
    }

    @ModelAttribute("findAllCategories")
    public List<Category> findAllCategories() {
        return categoryService.findALl();
    }


    @GetMapping("/index")
    public String index(@PageableDefault(size = 12) Pageable pageable, Model model) {
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
//        model.addAttribute("product", productService.findOne(id).get());
        return "front-end/index";
    }

    @GetMapping("/index/quick-view/{id}")
    public String indexQuickView(@PageableDefault(size = 12) Pageable pageable,@PathVariable Long id, Model model){
//        model.addAttribute("findTop4ByOrderByIdDesc", productService.findTop4ByOrderByIdDesc());
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
//        model.addAttribute("findTop4ByOrderByRatingDesc", productService.findTop4ByOrderByRatingDesc());
//        model.addAttribute("findAllCategories", categoryService.findALl());
        model.addAttribute("quickViewProduct", productService.findOne(id).get());
        return "front-end/shop-single-left-sidebar";

    }
}

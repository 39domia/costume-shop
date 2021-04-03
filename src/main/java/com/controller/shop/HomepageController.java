package com.controller.shop;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;
import com.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;

    @ModelAttribute("findTop4ByOrderByIdDesc")
    public List<Product> findTop4ByOrderByIdDesc() {
        return productService.findTop4ByIsDeleteIsFalseOrderByIdDesc();
    }

    @ModelAttribute("findTop4ByOrderByRatingDesc")
    public List<Product> findTop4ByOrderByRatingDesc() {
        return productService.findTop4ByIsDeleteIsFalseOrderByRatingDesc();
    }

    @ModelAttribute("findAllCategories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }


    @GetMapping("/index")
    public String index(@PageableDefault(size = 12) Pageable pageable, Model model) {
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
//        model.addAttribute("product", productService.findOne(id).get());
        return "front-end/index";
    }

    @GetMapping("/index/quick-view/{id}")
    public String indexQuickView(@PageableDefault(size = 12) Pageable pageable, @PathVariable Long id, Model model) {
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
        model.addAttribute("quickViewProduct", productService.findOne(id).get());
        return "front-end/quick-view";
    }

    @GetMapping("/shop")
    public String shopView(@PageableDefault(size = 12) Pageable pageable, Model model) {
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
        return "front-end/shop";
    }

    @GetMapping("/show-product")
    public String showProduct(@PageableDefault(size = 12) Pageable pageable, Model model) {
        return "front-end/layout/nav-bar";
    }

    @GetMapping("/shop/category/{id}")
    public String showCategoryProduct(@PageableDefault(size = 12) Pageable pageable, Model model, @PathVariable Long id) {
        model.addAttribute("showCategoryProduct", productRepository.findAllByCategoryIdAndDeletedIsFalse(id, pageable));
        return "front-end/shop-category";
    }

}

package com.controller;

import com.model.Category;
import com.model.Product;
import com.service.CategoryServiceImpl;
import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/product")
    public String showAllCategories(Model model, @PageableDefault(size = 20) Pageable pageable) {
        model.addAttribute("products", productService.selectAll(pageable));
        return "back-end/product/product-list";
    }

    @GetMapping("/product/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findOne(id).get());
        return "back-end/product/product-view";
    }

    @GetMapping("/product/create")
    public String showProductAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findALl());
        return "back-end/product/product-add";
    }

    @PostMapping("/product/create")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
//        new Product().validate(product, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/product/product-add";
        } else {
            productService.add(product);
            return "redirect:/product";
        }
    }

    @GetMapping("/product/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findOne(id).get());
        model.addAttribute("categories", categoryService.findALl());

        return "back-end/product/product-edit";
    }

    @PostMapping("/product/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
//        new Product().validate(product, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/product/product-edit";
        } else {
            productService.update(product);
            return "redirect:/product";
        }
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/product/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(size = 20) Pageable pageable) {
        Page<Product> products = productService.findByNameProductContaining(keyword, pageable);
        model.addAttribute("products", products);
        if (!products.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/product/product-list";
    }
}

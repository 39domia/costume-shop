package com.controller;

import com.model.Category;
import com.model.Product;
import com.service.CategoryServiceImpl;
import com.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @ModelAttribute
    public List<Category> categoryList(){
        return categoryService.findALl();
    }
    @ModelAttribute
    public Optional<Category> categoryById(Long id){
        return categoryService.findOne(id);
    }

    @GetMapping("/product")
    public String showAllCategories(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("products", productService.selectAll(pageable));
        return "back-end/product/product-list";
    }

    @GetMapping("/product/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findOne(id));
        return "back-end/category/category-view";
    }

    @GetMapping("/product/create")
    public String showProductAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryList());
        return "back-end/product/product-add";
    }

    @PostMapping("/product/create")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        new Product().validate(product, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/product/product-add";
        } else {
            productService.add(product);
            return "redirect:/product";
        }
    }

    @GetMapping("/product/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findOne(id));
        return "back-end/product/product-edit";
    }

    @PostMapping("/product/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        new Product().validate(product, bindingResult);
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
}

package com.controller;

import com.model.Product;
import com.model.User;
import com.repository.UserRepository;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CategoryService categoryService;

    private String getPrincipal() {
        String userName = null;
        Object prinObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (prinObject instanceof UserDetails) {
            userName = ((UserDetails) prinObject).getUsername();
        } else {
            userName = prinObject.toString();
        }
        return userName;
    }

    @GetMapping
    public String showAll(Model model, @PageableDefault(size = 12) Pageable pageable, HttpSession session) {
        User user = userRepository.findByEmail(getPrincipal());
        session.setAttribute("user", user);
        model.addAttribute("products", productService.selectAll(pageable));
        return "back-end/product/product-list";
    }

    @GetMapping("view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findOne(id).get());
        return "back-end/product/product-view";
    }

    @GetMapping("create")
    public String showProductAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "back-end/product/product-add";
    }

    @PostMapping("create")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Product().validate(product, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "back-end/product/product-add";
        } else {
            productService.add(product);
            attributes.addFlashAttribute("mess", "Add success");
            return "redirect:/product";
        }
    }

    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findOne(id).get());
        model.addAttribute("categories", categoryService.findAll());

        return "back-end/product/product-edit";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Product().validate(product, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "back-end/product/product-edit";
        } else {
            productService.update(product);
            attributes.addFlashAttribute("mess", "Update success");
            return "redirect:/product";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.softDelete(id);
        return "redirect:/product";
    }

    @GetMapping("search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(size = 20) Pageable pageable) {
        Page<Product> products = productService.findByNameProductAndIsDeleteContaining(keyword, pageable);
        model.addAttribute("products", products);
        if (!products.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/product/product-list";
    }
}

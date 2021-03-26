package com.controller;

import com.model.Category;
import com.service.CategoryServiceImpl;
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

@Controller
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/category")
    public String showAllCategories(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("categories", categoryService.selectAll(pageable));
        return "back-end/category/category-list";
    }

    @GetMapping("/category/view/{id}")
    public String viewCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findOne(id));
        return "back-end/category/category-view";
    }

    @GetMapping("/category/create")
    public String showCategoryAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "back-end/category/category-add";
    }

    @PostMapping("/category/create")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        new Category().validate(category, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/category/category-add";
        } else {
            categoryService.add(category);
            return "redirect:/category";
        }
    }

    @GetMapping("/category/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findOne(id));
        return "back-end/category/category-edit";
    }

    @PostMapping("/category/update")
    public String update(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        new Category().validate(category, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/category/category-edit";
        } else {
            categoryService.update(category);
            return "redirect:/category";
        }
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
}

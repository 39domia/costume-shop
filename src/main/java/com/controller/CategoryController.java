package com.controller;

import com.model.Category;
import com.repository.CategoryRepository;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String showAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("categories", categoryService.selectAll(pageable));
        return "back-end/category/category-list";
    }

    @GetMapping("/category/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findOne(id).get());
        return "back-end/category/category-view";
    }

    @GetMapping("/category/create")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "back-end/category/category-add";
    }

    @PostMapping("/category/create")
    public String add(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Category().validate(category, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/category/category-add";
        } else {
            categoryService.add(category);
            attributes.addFlashAttribute("mess", "Add success");
            return "redirect:/category";
        }
    }

    @GetMapping("/category/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findOne(id).get());
        return "back-end/category/category-edit";
    }

    @PostMapping("/category/update")
    public String update(@Validated @ModelAttribute("category") Category category, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Category().validate(category, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/category/category-edit";
        }

        Category categoryTemp = categoryRepository.findByName(category.getName());
        if (categoryTemp != null) {
            if (category.getName().equals(categoryTemp.getName()) && categoryTemp.getId() != category.getId()) {
                attributes.addFlashAttribute("mess", "Name already exists");
                return "redirect:/category";
            }
        }
        categoryService.update(category);
        attributes.addFlashAttribute("mess", "Update success");
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

    @GetMapping("/category/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Category> categories = categoryService.findByNameContaining(keyword, pageable);
        model.addAttribute("categories", categories);
        if (!categories.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/category/category-list";
    }
}

package com.controller;

import com.model.User;
import com.service.CategoryServiceImpl;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/user")
    public String showAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("users", service.selectAll(pageable));
        return "back-end/user/user-list";
    }

    @GetMapping("/user/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findOne(id));
        return "back-end/user/user-view";
    }

    @GetMapping("/user/create")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "back-end/user/user-add";
    }

    @PostMapping("/user/create")
    public String add(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
//        new User().validate(user, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/user/user-add";
//        } else {
        service.add(user);
        return "redirect:/user";
//        }
    }

    @GetMapping("/user/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findOne(id));
        return "back-end/user/user-edit";
    }

    @PostMapping("/user/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
//        new User().validate(user, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/user/user-edit";
//        } else {
        service.update(user);
        return "redirect:/user";
//        }
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user";
    }
}

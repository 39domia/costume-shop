package com.controller;

import com.model.Customer;
import com.service.CustomerServiceImpl;
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
public class CustomerController {

    @Autowired
    private CustomerServiceImpl service;

    @GetMapping("/customer")
    public String showAllCategories(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customers", service.selectAll(pageable));
        return "back-end/customer/customer-list";
    }

    @GetMapping("/customer/create")
    public String showCustomerAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "back-end/customer/customer-add";
    }

    @PostMapping("/customer/create")
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/customer/customer-add";
        } else {
            service.add(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.findOne(id));
        return "back-end/customer/customer-edit";
    }

    @PostMapping("/customer/update")
    public String update(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/customer/customer-edit";
        } else {
            service.update(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/customer";
    }
}

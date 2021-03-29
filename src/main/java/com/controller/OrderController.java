package com.controller;


import com.model.Order;
import com.service.OrderServiceImpl;
import com.service.ProvinceServiceImpl;
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
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @Autowired
    private ProvinceServiceImpl provinceService;

    @GetMapping("/order")
    public String showAllCategories(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("orders", service.selectAll(pageable));
        return "back-end/order/order-list";
    }

    @GetMapping("/order/view/{id}")
    public String viewCategory(@PathVariable Long id, Model model){
        model.addAttribute("viewOrder", service.findOne(id));
        return "back-end/order/order-view";
    }

    @GetMapping("/order/create")
    public String showOrderAddForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("provinces", provinceService.findALl());
        return "back-end/order/order-add";
    }

    @PostMapping("/order/create")
    public String addOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {
//        new Order().validate(order, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/order/order-add";
//        } else {
        service.add(order);
        return "redirect:/order";
//        }
    }

    @GetMapping("/order/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("order", service.findOne(id));
        model.addAttribute("provinces", provinceService.findALl());
        return "back-end/order/order-edit";
    }

    @PostMapping("/order/update")
    public String update(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {
//        new Order().validate(order, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/order/order-edit";
//        } else {
        service.update(order);
        return "redirect:/order";
//        }
    }

    @GetMapping("/order/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/order";
    }

}

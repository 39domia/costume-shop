package com.controller;


import com.model.Order;
import com.service.*;
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
    private OrderService orderService;

    @Autowired
    private ProvinceService provinceService;


    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @GetMapping("/order")
    public String showAllCategories(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("orders", orderService.selectAll(pageable));
        return "back-end/order/order-list";
    }

    @GetMapping("/order/view/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        model.addAttribute("viewOrder", orderService.findOne(id).get());
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
        if (bindingResult.hasFieldErrors()) {
            return "back-end/order/order-add";
        } else {
            orderService.add(order);
            return "redirect:/order";
        }
    }

    @GetMapping("/order/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findOne(id).get());
        model.addAttribute("provinces", provinceService.findALl());
        return "back-end/order/order-edit";
    }

    @PostMapping("/order/update")
    public String update(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {
//        new Order().validate(order, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/order/order-edit";
        } else {
            orderService.update(order);
            return "redirect:/order";
        }
    }

    @GetMapping("/order/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/order";
    }

}

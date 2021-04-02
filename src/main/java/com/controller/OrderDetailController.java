package com.controller;

import com.model.OrderDetail;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OrderDetailController {


    @Autowired
    private OrderDetailService service;

    @GetMapping("/order-detail")
    public String showAll(Model model) {
//        model.addAttribute("orderDetails", service.selectAll());
        return "back-end/order/order-view";
    }

//    @GetMapping("/order-detail/view/{id}")
//    public String view(@PathVariable Long id, Model model) {
//        model.addAttribute("orderDetail", service.findOne(id).get());
//        return "back-end/order-detail/order-detail-view";
//    }

    @GetMapping("/order-detail/create")
    public String showAddForm(Model model) {
        model.addAttribute("orderDetail", new OrderDetail());
        return "back-end/order-detail/order-detail-add";
    }

    @PostMapping("/order-detail/create")
    public String add(@Valid @ModelAttribute("order-detail") OrderDetail orderDetail, BindingResult bindingResult, Model model) {
//        new OrderDetail().validate(orderDetail, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/order-detail/order-detail-add";
//        } else {
        service.add(orderDetail);
        return "redirect:/order-detail";
//        }
    }

    @GetMapping("/order-detail/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("orderDetail", service.findOne(id).get());
        return "back-end/order-detail/order-detail-edit";
    }

    @PostMapping("/order-detail/update")
    public String update(@Valid @ModelAttribute("order-detail") OrderDetail orderDetail, BindingResult bindingResult, Model model) {
//        new OrderDetail().validate(order-detail, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/order-detail/order-detail-edit";
//        } else {
        service.update(orderDetail);
        return "redirect:/order-detail";
//        }
    }


}


package com.controller.shop;

import com.model.Category;
import com.model.Order;
import com.model.OrderDetail;
import com.repository.ProvinceRepository;
import com.service.CategoryService;
import com.service.OrderDetailService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("findAllCategories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/checkout")
    public String showCheckout( Model model){
        model.addAttribute("order",new Order());
        model.addAttribute("provinces", provinceRepository.findAll());
        return "front-end/checkout";
    }

    @PostMapping("/checkout/addOrder")
    public String addOrder(@ModelAttribute Order order,
                           HttpServletRequest request,
                           HttpSession session, Model model) {
        Order orderSession = (Order) session.getAttribute("order");
        order.setTotalPrice(orderSession.getTotalPrice());
        order.setOrderDetails(orderSession.getOrderDetails());
        orderService.add(order);
        for (OrderDetail orderDetail1 : order.getOrderDetails()) {
            orderDetail1.setOrder(order);
            orderDetailService.add(orderDetail1);
        }
        session.setAttribute("order", null);
        model.addAttribute("mess", "Done");
        return "front-end/checkout-result";
    }
}

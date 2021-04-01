package com.controller.shop;

import com.model.OrderDetail;
import com.model.Product;
import com.service.ProductServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/cart/add")
    public String add(Model model, @RequestParam Product product, HttpServletRequest request){
//        OrderDetail cart = (OrderDetail) request.getSession().setAttribute("cart",value);
        return "/front-end/index";
    }
}

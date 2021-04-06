package com.controller.shop;

import com.model.Category;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.repository.ProvinceRepository;
import com.service.CategoryService;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.service.ProductService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @Autowired
    ProductService productService;

    @ModelAttribute("findTop4ByOrderByIdDesc")
    public List<Product> findTop4ByOrderByIdDesc() {
        return productService.findTop4ByIsDeleteIsFalseOrderByIdDesc();
    }

    @ModelAttribute("findTop4ByOrderByRatingDesc")
    public List<Product> findTop4ByOrderByRatingDesc() {
        return productService.findTop4ByIsDeleteIsFalseOrderByRatingDesc();
    }

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
    public String addOrder(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, RedirectAttributes attributes,
                           HttpServletRequest request,
                           @PageableDefault(size = 12) Pageable pageable,
                           @RequestParam(defaultValue = "") String keyword,
                           HttpSession session, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("provinces", provinceRepository.findAll());
            return "front-end/checkout";

        }
        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
        Page<Product> products = productService.findByNameProductAndIsDeleteContaining(keyword, pageable);
        model.addAttribute("selectAllPage12", products);
        if (!products.hasContent())
            model.addAttribute("searchMess", "Not found");

        Order orderSession = (Order) session.getAttribute("order");
        order.setTotalPrice(orderSession.getTotalPrice());
        order.setOrderDetails(orderSession.getOrderDetails());
        orderService.add(order);
        for (OrderDetail orderDetail1 : order.getOrderDetails()) {
            orderDetail1.setOrder(order);
            orderDetailService.add(orderDetail1);
        }
        session.setAttribute("order", null);
        model.addAttribute("mess", "Order Success");
        return "front-end/checkout-result";
    }
//    @GetMapping("/shop")
//    public String shopView(@PageableDefault(size = 12) Pageable pageable, Model model) {
//        model.addAttribute("selectAllPage12", productService.selectAll(pageable));
//        return "front-end/checkout-result";
//    }
//    @GetMapping("/index/search")
//    public String search(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(size = 12) Pageable pageable) {
//        Page<Product> products = productService.findByNameProductAndIsDeleteContaining(keyword, pageable);
//        model.addAttribute("selectAllPage12", products);
//        if (!products.hasContent())
//            model.addAttribute("searchMess", "Not found");
//        return "front-end/checkout-result";
//    }
}
package com.controller.shop;

import com.model.Category;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("findAllCategories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/cart/add/{id}/{quantity}")
    public String add(@PathVariable(value = "id") Long id,
                      @PathVariable Integer quantity,
                      HttpServletRequest request,
                      HttpSession session) throws SQLException {
        Optional<Product> optionalProduct = productService.findOne(id);
        if (optionalProduct.isEmpty())
            return "redirect:/shop";
        Product product = optionalProduct.get();

        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            order = new Order();
            order.setOrderDetails(new ArrayList<>());
        }
        // order cờ
        boolean exists = false;
        // co san trong order
        double total = 0;

        for (OrderDetail orderDetail : order.getOrderDetails()) {
            if (orderDetail.getProduct().getId().equals(product.getId())) {
                Integer quantity1 = orderDetail.getQuantity();
                Integer newQuantity = quantity + quantity1;
                orderDetail.setQuantity(newQuantity);
                orderDetail.setPriceOder(newQuantity * product.getPrice());
                exists = true;
                break;
            }
        }
        // chua co trong order
        if (!exists) {
            OrderDetail detail = new OrderDetail();
            detail.setId(product.getId());
            detail.setProduct(product);
            detail.setQuantity(quantity);
            detail.setPriceOder(quantity * product.getPrice());
            order.getOrderDetails().add(detail);
        }
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            total += orderDetail.getProduct().getPrice() * orderDetail.getQuantity();
        }
        order.setTotalPrice(total);
        session.setAttribute("order", order);
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/cart/showCart")
    public String showListCart(HttpServletRequest request, HttpSession session) throws SQLException {
        return "front-end/cart";
    }

    @GetMapping("/cart/showCart/deleteProduct/{idProduct}")
    public String deleteProductInCart(@PathVariable(name = "idProduct") Long idProduct, HttpSession session, HttpServletRequest request) throws SQLException {
        Order order = (Order) session.getAttribute("order");

        if (order == null)
            throw new RuntimeException("Invalid request");

        List<OrderDetail> details = order.getOrderDetails();
        if (details.size() == 1) {
            session.setAttribute("order", null);
            return "redirect:" + request.getHeader("Referer");
        }

//        list co nhieu sp
        OrderDetail removing = null;
        for (OrderDetail detail : details) {
            if (detail.getId().equals(idProduct)) {
                removing = detail;
                break;
            }
        }
        if (removing == null)
            throw new RuntimeException("Invalid request");

        details.remove(removing);

        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.getProduct().getPrice() * detail.getQuantity();
        }
        order.setTotalPrice(total);
        return "redirect:" + request.getHeader("Referer");
    }

}

package com.controller.shop;

import com.model.Category;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("findAllCategories")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("add/{id}/{quantity}")
    public String add(@PathVariable(value = "id") Long id,
                      @PathVariable Integer quantity,
                      HttpServletRequest request,
                      RedirectAttributes attributes,
                      HttpSession session) throws SQLException {
        Optional<Product> optionalProduct = productService.findOne(id);
        if (!optionalProduct.isPresent())
            return "redirect:/shop";

        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            order = new Order();
            order.setOrderDetails(new ArrayList<>());
        }
        // order cờ
        boolean exists = false;
        // sản phẩm đã có trong order và thêm số lượng
        double total = 0;

        Product product = optionalProduct.get();
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
        attributes.addFlashAttribute("addMess", "Add to card success");
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("showCart")
    public String showListCart(HttpServletRequest request, HttpSession session) throws SQLException {
        return "front-end/cart";
    }

    @GetMapping("update/{data}")
    public String updateCart(@PathVariable("data") String data,
                             HttpSession session,
                             RedirectAttributes attributes,
                             Model model,
                             HttpServletRequest request) {
        Map<Long, Integer> quantityMap = new HashMap<>();
        try {
            String[] parts = data.split("-");
            for (String part : parts) {
                String[] dataPart = part.split(":");
                Long productId = Long.parseLong(dataPart[0]);
                Integer productQuantity = Integer.parseInt(dataPart[1]);
                quantityMap.put(productId, productQuantity);
            }
        } catch (Exception e) {
            throw new RuntimeException("request invalid");
        }
        Order order = (Order) session.getAttribute("order");
        List<OrderDetail> detailList = order.getOrderDetails();
        for (OrderDetail detail : detailList) {
            Product currProduct = detail.getProduct();
            Integer quantity = quantityMap.get(currProduct.getId());
            if (quantity != null)
                detail.setQuantity(quantity);
            detail.setPriceOder(detail.getProduct().getPrice() * detail.getQuantity());
        }
        double total = 0;
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            total += orderDetail.getProduct().getPrice() * orderDetail.getQuantity();
        }
        order.setTotalPrice(total);
        session.setAttribute("order", order);
//        attributes.addFlashAttribute("updMess", "Update card success");
        model.addAttribute("updMess", "Update card success");
        return "front-end/cart";

    }

    @GetMapping("showCart/deleteProduct/{idProduct}")
    public String deleteProductInCart(@PathVariable(name = "idProduct") Long idProduct,
                                      HttpSession session,
                                      RedirectAttributes attributes,
                                      Model model,
                                      HttpServletRequest request) throws SQLException {
        Order order = (Order) session.getAttribute("order");

        if (order == null)
            throw new RuntimeException("Invalid request");

        List<OrderDetail> details = order.getOrderDetails();
        if (details.size() == 1) {
            session.setAttribute("order", null);
//            attributes.addFlashAttribute("delMess", "Delete card success");
            model.addAttribute("delMess", "Delete card success");
            return "front-end/cart";
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
//        attributes.addFlashAttribute("delMess", "Delete card success");
        model.addAttribute("delMess", "Delete card success");
        return "front-end/cart";
    }

}

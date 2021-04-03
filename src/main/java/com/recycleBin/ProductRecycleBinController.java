package com.recycleBin;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/recycle/product")
public class ProductRecycleBinController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String showAllCategories(Model model,
                                    @PageableDefault(size = 20) Pageable pageable
    ) {
        model.addAttribute("products", productService.findAllByDeletedIsTrue(pageable));
        return "back-end/recycle-bin/product/recycle-list";
    }

    @GetMapping("view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findByIdAndDeletedIsTrue(id).get());
        return "back-end/recycle-bin/product/recycle-view";
    }

    @GetMapping("recovery/{id}")
    public String recovery(@PathVariable Long id) {
        Product product = productService.findByIdAndDeletedIsTrue(id).get();
        product.setDeleted(false);
        productService.update(product);
        return "redirect:/recycle/product";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteTrue(id);
        return "redirect:/recycle/product";
    }

    @GetMapping("search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(size = 20) Pageable pageable) {
        Page<Product> products = productService.findByDeletedIsTrueAndNameProductContaining(keyword, pageable);
        model.addAttribute("products", products);
        if (!products.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/recycle-bin/product/recycle-list";
    }
}

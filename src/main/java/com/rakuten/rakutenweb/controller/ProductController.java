package com.rakuten.rakutenweb.controller;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
    @GetMapping("/new-product")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
    @PostMapping("/new-product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }
    @GetMapping("/update-product{id}")
    public String updateProduct(@PathVariable(value = "id") long id, Model model){
        Product product = productService.updateProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }
    @GetMapping("/delete-product{id}")
    public String deleteProduct(@PathVariable(value = "id") long id){
        productService.deleteProductById(id);
        return "redirect:/";
    }


}
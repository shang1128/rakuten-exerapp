package com.rakuten.rakutenweb.controller;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.repository.ProductRepository;
import com.rakuten.rakutenweb.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

}
package com.rakuten.rakutenweb.controller;


import com.rakuten.rakutenweb.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("")
    public String showHomePage(Model model){
        model.addAttribute("pageTitle", "Home - Product List");
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        User user = new User();
        return "register";
    }
}

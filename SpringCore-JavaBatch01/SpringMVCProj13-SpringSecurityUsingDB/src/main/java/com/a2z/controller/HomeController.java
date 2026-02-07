package com.a2z.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.a2z.entity.UserEntity;
import com.a2z.service.IUserServiceMgmt;

@Controller
public class HomeController {

    @Autowired
    private IUserServiceMgmt userService;

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("user") UserEntity user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") UserEntity user,
                         RedirectAttributes attr) {

        String msg = userService.registerUser(user);
        attr.addFlashAttribute("msg", msg);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") UserEntity user) {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth) {

        String role = auth.getAuthorities().toString();

        if (role.contains("ADMIN")) {
            return "admin";
        }

        if (role.contains("USER")) {
            return "user";
        }

        return "403";
    }
}

package com.example.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    /**
     * Custom login page shown at: /my_login
     */
    @GetMapping("/my_login")
    public String loginPage() {
        return "login"; // renders login.html
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal OidcUser user) {

        String fullName = user.getAttribute("name");
        String email = user.getEmail();
        String picture = user.getAttribute("picture");

        model.addAttribute("name", fullName);
        model.addAttribute("email", email);
        model.addAttribute("picture", picture);
        return "dashboard";
    }

    /**
     * Optional home page (accessible without login)
     */
    @GetMapping("/")
    public String home() {
        return "home"; // renders home.html if you want
    }
}
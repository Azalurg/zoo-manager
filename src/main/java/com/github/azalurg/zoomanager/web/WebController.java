package com.github.azalurg.zoomanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class WebController {
    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request, Model model){
        model.addAttribute("error", request.getAttribute("javax.servlet.error.message"));
        return "error";
    }
}

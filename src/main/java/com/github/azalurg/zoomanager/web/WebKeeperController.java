package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/keepers")
public class WebKeeperController {

    @Autowired
    private KeeperService keeperService;

    @GetMapping("/login")
    public String login() {
        return "keepers/login";
    }

//    @GetMapping("/profile")
//    public String profile(Model model) {
//        // get logged-in keeper
//        Keeper keeper = ...;
//        model.addAttribute("keeper", keeper);
//        return "keepers/profile";
//    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Keeper keeper = keeperService.findByUsername(username);
        if (keeper != null && password.equals(keeper.getPassword())) {
            // login successful
            return "redirect:/keepers/profile";
        } else {
            // login failed
            model.addAttribute("error", "Invalid username or password");
            return "keepers/login";
        }
    }
}


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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/keepers")
public class WebKeeperController {

    @Autowired
    private KeeperService keeperService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("error", "");
        return "keepers/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        // get logged-in keeper from the session attribute
        Keeper keeper = (Keeper) session.getAttribute("loggedInUser");
        model.addAttribute("keeper", keeper);
        return "keepers/profile";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Keeper keeper = keeperService.findByUsername(username);
        if (keeper != null && password.equals(keeper.getPassword())) {
            // login successful, store the logged-in keeper in a session attribute
            session.setAttribute("loggedInUser", keeper);
            return "redirect:/keepers/profile";
        } else {
            // login failed
            model.addAttribute("error", "Invalid username or password");
            return "keepers/login";
        }
    }
}


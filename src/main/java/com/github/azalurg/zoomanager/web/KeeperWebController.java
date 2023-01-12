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

import java.util.Objects;

import static com.github.azalurg.zoomanager.custom.RandomId.randomString;

@Controller
@RequestMapping("/keepers")
public class KeeperWebController {

    @Autowired
    private KeeperService keeperService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("error", "");
        return "keepers/login";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam(required = false, defaultValue = "") String sessionKey, Model model, HttpSession session) {

        if (!Objects.equals(sessionKey, "")) {
            // check if the session key is valid
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                model.addAttribute("keeper", keeper);
                return "keepers/profile";
            }
        }

        model.addAttribute("error", "Session key is invalid");
        return "keepers/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Keeper keeper = keeperService.findByUsername(username);

        if (keeper != null && password.equals(keeper.getPassword())) {
            String sessionKey = randomString(16);
            session.setAttribute(sessionKey, keeper);
            model.addAttribute("sessionKey", sessionKey);
            return "/keepers/setSession";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "keepers/login";
        }
    }
}


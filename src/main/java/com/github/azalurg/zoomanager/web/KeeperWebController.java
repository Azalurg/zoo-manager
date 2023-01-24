package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
                model.addAttribute("animals", keeperService.getKeeperAnimals(keeper));
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

    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("keeper", new Keeper());
        return "keepers/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("keeper") Keeper keeper, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "keepers/register";
        }

        keeperService.createKeeper(keeper);
        return "redirect:/keepers/login";
    }

    @GetMapping("/update")
    public String updateGet(@RequestParam(required = false, defaultValue = "") String sessionKey, Model model, HttpSession session) {
        if (!Objects.equals(sessionKey, "")) {
            // check if the session key is valid
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                model.addAttribute("keeper", keeper);
                return "keepers/update";
            }
        }

        model.addAttribute("sessionKey", sessionKey);
        model.addAttribute("error", "Session key is invalid");
        return "keepers/login";
    }

    @PostMapping("/update")
    public String updatePost(@RequestParam(required = false, defaultValue = "") String sessionKey, @Valid @ModelAttribute("keeper") Keeper keeper, Errors errors, Model model, HttpSession session) {
        if (errors.hasErrors()) {
            return "keepers/update";
        }

        if (!Objects.equals(sessionKey, "")) {
            // check if the session key is valid
            Keeper keeperFromSession = (Keeper) session.getAttribute(sessionKey);
            if (keeperFromSession != null) {
                keeperService.updateKeeper(keeperFromSession.getId(), keeper);
                return "redirect:/keepers/profile?sessionKey=" + sessionKey;
            }
        }

        model.addAttribute("error", "Session key is invalid");
        return "keepers/login";
    }
}


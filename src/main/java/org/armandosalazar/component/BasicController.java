package org.armandosalazar.component;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }

    @GetMapping(path = {"/home", "/hello", "/gallery", "/posts"})
    public String home() {
        return "home";
    }

}

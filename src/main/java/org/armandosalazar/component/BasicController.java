package org.armandosalazar.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(path = {"/home", "/hello"})
    public String home() {
        return "home";
    }

}

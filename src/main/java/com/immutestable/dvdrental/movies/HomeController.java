package com.immutestable.dvdrental.movies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController { // TODO remove

    @RequestMapping("/")
    @ResponseBody
    public String greeting() {
        return "Hello, World";
    }
}

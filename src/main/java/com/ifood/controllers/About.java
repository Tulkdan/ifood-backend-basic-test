package com.ifood.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class About {

    @RequestMapping(path = "/about")
    public String index() {
        return "This service is working as it should";
    }

}

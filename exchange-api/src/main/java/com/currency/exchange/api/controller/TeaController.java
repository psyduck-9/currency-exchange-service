package com.currency.exchange.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeaController {

    @GetMapping("/tea")
    public String getTea(){
        return "Here's a cup of tea from currency exchange service!";
    }
}

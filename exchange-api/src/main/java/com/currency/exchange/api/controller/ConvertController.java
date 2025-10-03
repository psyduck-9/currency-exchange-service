package com.currency.exchange.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @GetMapping("/hello")
    public String hello() {
        return "Currency Exchange Service is running!";
    }
}

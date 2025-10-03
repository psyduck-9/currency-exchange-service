package com.currency.exchange.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.currency.exchange")
public class ExchangeApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeApiApplication.class, args);
    }
}

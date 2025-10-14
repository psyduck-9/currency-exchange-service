package com.currency.exchange.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.currency.exchange")
@EnableJpaRepositories(basePackages = "com.currency.exchange.infra.persistence.repository")  // ✅ Add this
@EntityScan(basePackages = "com.currency.exchange.infra.persistence.entity")
public class ExchangeApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExchangeApiApplication.class, args);
  }
}

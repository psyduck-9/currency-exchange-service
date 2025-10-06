package com.currency.exchange.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Currency Exchange Service API",
            version = "1.0",
            description = "Provides exchange rate and currency conversion APIs"))
public class OpenApiConfig {}

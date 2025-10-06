package com.currency.exchange.api.controller;

import com.currency.exchange.core.domain.ExchangeRate;
import com.currency.exchange.core.service.ExchangeRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/conversion")
public class ConvertController {

  private final ExchangeRateService exchangeRateService;

  public ConvertController(ExchangeRateService exchangeRateService) {
    this.exchangeRateService = exchangeRateService;
  }

  @GetMapping("/rate")
  public ExchangeRate getConversionRate(
      @RequestParam String fromCurrency, @RequestParam String toCurrency) {
    return exchangeRateService.getRate(fromCurrency, toCurrency);
  }
}

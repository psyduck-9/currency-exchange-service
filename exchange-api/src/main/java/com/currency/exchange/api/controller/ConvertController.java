package com.currency.exchange.api.controller;

import com.currency.exchange.api.domain.model.ExchangeRate;
import com.currency.exchange.api.service.ExchangeRateService;
import java.time.LocalDate;
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
      @RequestParam("from") String fromCurrency, @RequestParam("to") String toCurrency) {
    return exchangeRateService.getRate(fromCurrency, toCurrency, LocalDate.now());
  }
}

package com.currency.exchange.core.domain.service;

import com.currency.exchange.core.domain.model.ExchangeRate;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

  public ExchangeRate getRate(String fromCurrency, String toCurrency) {
    // TODO: remove hardcoded rate
    return new ExchangeRate(fromCurrency, toCurrency, 10.05);
  }
}

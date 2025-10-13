package com.currency.exchange.core.exceptions;

public class ExchangeRateNotFoundException extends RuntimeException {

  public ExchangeRateNotFoundException(String message) {
    super(message);
  }
}

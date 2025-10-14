package com.currency.exchange.api.domain.model;

import com.currency.exchange.infra.persistence.entity.ExchangeRateEntity;
import java.math.BigDecimal;

public record ExchangeRate(String fromCurrency, String toCurrency, BigDecimal rate) {

  public static ExchangeRate fromEntity(ExchangeRateEntity entity) {
    return new ExchangeRate(
        entity.getBaseCurrencyCode(), entity.getTargetCurrencyCode(), entity.getRate());
  }
}

package com.currency.exchange.api.service;

import com.currency.exchange.api.domain.model.ExchangeRate;
import com.currency.exchange.core.exceptions.ExchangeRateNotFoundException;
import com.currency.exchange.infra.persistence.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;

  public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
    this.exchangeRateRepository = exchangeRateRepository;
  }

  public ExchangeRate getLatestCurrencyConversionRate(String fromCurrency, String toCurrency)
      throws ExchangeRateNotFoundException {
    return exchangeRateRepository
        .findTopByBaseCurrencyCodeAndTargetCurrencyCodeOrderByEffectiveDateDesc(
            fromCurrency, toCurrency)
        .map(ExchangeRate::fromEntity)
        .orElseThrow(
            () ->
                new ExchangeRateNotFoundException(
                    "No Exchange rate found for " + fromCurrency + " to " + toCurrency));
  }
}

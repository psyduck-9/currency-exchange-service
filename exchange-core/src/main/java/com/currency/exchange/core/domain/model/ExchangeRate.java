package com.currency.exchange.core.domain.model;

public record ExchangeRate(String fromCurrency, String toCurrency, double rate) {}

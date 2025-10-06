package com.currency.exchange.core.domain;

public record ExchangeRate(String fromCurrency, String toCurrency, double rate) {}

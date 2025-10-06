package com.currency.exchange.core.service;

import com.currency.exchange.core.domain.ExchangeRate;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    public ExchangeRate getRate(String fromCurrency, String toCurrency){
        // TODO: remove hardcoded rate
        return new ExchangeRate( fromCurrency, toCurrency, 10.05);
    }
}

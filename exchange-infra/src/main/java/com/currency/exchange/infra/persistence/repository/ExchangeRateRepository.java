package com.currency.exchange.infra.persistence.repository;

import com.currency.exchange.infra.persistence.entity.ExchangeRateEntity;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

  Optional<ExchangeRateEntity>
      findTopByBaseCurrencyCodeAndTargetCurrencyCodeOrderByEffectiveDateDesc(
          String baseCurrencyCode, String targetCurrencyCode, LocalDate date);

  ExchangeRateEntity findFirstByBaseCurrencyCodeAndTargetCurrencyCode(
      @NonNull String baseCurrencyCode, String targetCurrencyCode);
}

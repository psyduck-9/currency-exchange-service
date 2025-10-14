package com.currency.exchange.infra.persistence.repository;

import com.currency.exchange.infra.persistence.entity.ExchangeRateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

  Optional<ExchangeRateEntity>
      findTopByBaseCurrencyCodeAndTargetCurrencyCodeOrderByEffectiveDateDesc(
          String baseCurrencyCode, String targetCurrencyCode);
}

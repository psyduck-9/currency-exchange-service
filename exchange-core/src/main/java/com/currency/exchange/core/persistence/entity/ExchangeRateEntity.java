package com.currency.exchange.core.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "base_currency_code", length = 3, nullable = false)
  private String baseCurrencyCode;

  @Column(name = "target_currency_code", length = 3, nullable = false)
  private String targetCurrencyCode;

  @Column(name = "rate", precision = 19, scale = 6, nullable = false)
  private BigDecimal rate;

  @Column(name = "effective_date", nullable = false)
  private LocalDate effectiveDate;

  @Column(name = "source", nullable = false, length = 50)
  private String source;

  /*TODO: Move these fields to an auditable class*/
  @Column(name = "created_at", columnDefinition = "TIMESTAMPZ")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMPZ")
  private LocalDateTime updatedAt;

  @Column(name = "created_by", length = 100)
  private String createdBy;

  @Column(name = "created_by", length = 100)
  private String updatedBy;

  public ExchangeRateEntity() {
    // For JPA, do not remove
  }

  @PrePersist
  public void prePersist() {
    this.createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

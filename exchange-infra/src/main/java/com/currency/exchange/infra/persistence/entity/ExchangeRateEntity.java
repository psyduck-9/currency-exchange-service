package com.currency.exchange.infra.persistence.entity;

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

  public long getId() {
    return id;
  }

  public String getBaseCurrencyCode() {
    return baseCurrencyCode;
  }

  public String getTargetCurrencyCode() {
    return targetCurrencyCode;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public String getSource() {
    return source;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setBaseCurrencyCode(String baseCurrencyCode) {
    this.baseCurrencyCode = baseCurrencyCode;
  }

  public void setTargetCurrencyCode(String targetCurrencyCode) {
    this.targetCurrencyCode = targetCurrencyCode;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public void setEffectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }
}

CREATE TABLE exchange_rate (
  -- Primary Key: BIGSERIAL for production (handles billions of records)
  id BIGSERIAL PRIMARY KEY,

  -- Business Columns
  base_currency_code VARCHAR(3) NOT NULL,
  target_currency_code VARCHAR(3) NOT NULL,
  rate NUMERIC(19, 6) NOT NULL,
  effective_date DATE NOT NULL DEFAULT CURRENT_DATE,

  -- Source tracking
  source VARCHAR(50) NOT NULL, -- e.g., 'ECB', 'YAHOO_FINANCE', 'MANUAL'

  -- Audit Columns
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMPTZ,
  created_by VARCHAR(100),
  updated_by VARCHAR(100)
);
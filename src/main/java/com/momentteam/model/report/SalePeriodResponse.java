package com.momentteam.model.report;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalePeriodResponse {

  private long productId;
  private String productName;
  private Long quantity;
  private BigDecimal amount;

}

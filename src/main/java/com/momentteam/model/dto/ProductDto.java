package com.momentteam.model.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

  private long id;
  private String name;
  private String number;
  private BigDecimal price;

}

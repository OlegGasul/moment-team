package com.momentteam.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "sale")
@Data
@Builder
public class Sale {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "quantity")
  private Long quantity;

  @Column(name = "discount")
  private BigDecimal discount;

  @Column(name = "sale_date")
  private LocalDateTime saleDate;

}

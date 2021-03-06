package com.momentteam.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sale")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "product")
public class Sale {

  public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Min(value = 0, message = "Price should be non negative")
  @NotNull(message = "Price should be not null")
  private BigDecimal price;

  @Min(value = 1, message = "Quantity should be greater then zero")
  @NotNull(message = "Quantity should be not null")
  private Long quantity;

  @Min(value = 0, message = "Discount should be non negative")
  @Max(value = 100, message = "Discount should be 100% maximum")
  private BigDecimal discount = BigDecimal.ZERO;

  @NotNull(message = "Sale date should be not null")
  @Column(name = "sale_date")
  private LocalDateTime saleDate;

  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  @JsonBackReference()
  private Product product;

  @Min(value = 0, message = "Price should be non negative")
  @NotNull(message = "Total price should be not null")
  @Column(name = "total_price")
  private BigDecimal totalPrice = BigDecimal.ZERO;

  public void updateTotalPrice() {
    totalPrice = price.multiply(ONE_HUNDRED.subtract(discount).divide(ONE_HUNDRED));
  }

}

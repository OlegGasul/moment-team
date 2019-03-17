package com.momentteam.controller;

import com.momentteam.model.entity.Product;
import com.momentteam.model.entity.Sale;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public abstract class BaseTest {

  protected Product createProduct(long id, String name, String number, double price, Set<Sale> sales) {
    return Product.builder()
        .id(id)
        .name(name)
        .number(number)
        .price(BigDecimal.valueOf(price))
        .build();
  }

  protected Sale createSale(double price, long quantity, double discount, LocalDateTime saleDate) {
    return Sale.builder()
        .price(BigDecimal.valueOf(price))
        .quantity(quantity)
        .discount(BigDecimal.valueOf(discount))
        .saleDate(saleDate)
        .build();
  }

}

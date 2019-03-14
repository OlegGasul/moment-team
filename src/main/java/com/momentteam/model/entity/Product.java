package com.momentteam.model.entity;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
@Builder
public class Product {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "number")
  private String number;

  @Column(name = "price")
  private BigDecimal price;

  @OneToMany(mappedBy = "product")
  private Set<Sale> sales;

}

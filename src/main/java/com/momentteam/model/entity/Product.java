package com.momentteam.model.entity;

import static com.momentteam.model.entity.Product.GET_ALL;
import static com.momentteam.model.entity.Product.GET_PRODUCT_BY_ID;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "product")
@Data
@Builder
@NamedQuery(name = GET_ALL, query = "select p from Product")
@NamedQuery(name = GET_PRODUCT_BY_ID, query = "select p from Product where id = ?")
public class Product {
  public static final String GET_ALL = "getAllProducts";
  public static final String GET_PRODUCT_BY_ID = "getProductById";

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

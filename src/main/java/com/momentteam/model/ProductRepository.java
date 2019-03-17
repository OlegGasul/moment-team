package com.momentteam.model;

import com.momentteam.model.entity.Product;
import com.momentteam.model.report.SalePeriodResponse;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

  @Query("SELECT new com.momentteam.model.report.SalePeriodResponse(s.product.id, s.product.name, SUM(s.quantity), SUM(s.totalPrice)) FROM Sale s WHERE s.product.id = ?1 AND s.saleDate between ?2 AND ?3 GROUP BY s.product.id, s.product.name")
  SalePeriodResponse findSalesInPeriod(long productId, LocalDateTime dateFrom, LocalDateTime dateTo);

  @Query("SELECT new com.momentteam.model.report.SalePeriodResponse(s.product.id, s.product.name, SUM(s.quantity), SUM(s.totalPrice)) FROM Sale s WHERE s.saleDate between ?1 AND ?2 GROUP BY s.product.id, s.product.name")
  List<SalePeriodResponse> findSalesInPeriod(LocalDateTime dateFrom, LocalDateTime dateTo);

}
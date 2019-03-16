package com.momentteam.model;

import com.momentteam.model.entity.Product;
import com.momentteam.model.entity.Sale;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

  @Query("SELECT s FROM Sale s WHERE s.product.id = ?1 and s.saleDate between ?2 AND ?3")
  List<Sale> findSalesInPeriod(long productId, LocalDateTime dateFrom, LocalDateTime dateTo);

}

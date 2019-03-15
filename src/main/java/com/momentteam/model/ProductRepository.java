package com.momentteam.model;

import com.momentteam.model.entity.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  List<Product> findByNameIgnoreCaseContaining(String name);
}

package com.momentteam.model;

import com.momentteam.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}

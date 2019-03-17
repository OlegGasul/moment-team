package com.momentteam.service;

import com.momentteam.model.entity.Product;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  Product save(Product product);

  Iterable<Product> findAll();

  Optional<Product> findById(long id);

}

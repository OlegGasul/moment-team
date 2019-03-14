package com.momentteam.service;

import com.momentteam.model.ProductRepository;
import com.momentteam.model.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Iterable<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(long id) {
    return productRepository.findById(id);
  }
}

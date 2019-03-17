package com.momentteam.service;

import com.momentteam.exception.ProductNotFoundException;
import com.momentteam.model.ProductRepository;
import com.momentteam.model.entity.Product;
import com.momentteam.model.report.SalePeriodResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product save(Product product) {
    product.getSales().forEach(sale -> {
      sale.setProduct(product);
      sale.updateTotalPrice();
    });

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

  @Override
  public SalePeriodResponse searchForSales(long productId, LocalDate dateFrom, LocalDate dateTo) {
    Product product = get(productId);
    if (product == null) {
      throw new ProductNotFoundException(productId);
    }

    return productRepository.findSalesInPeriod(productId, dateFrom.atStartOfDay(), dateTo.atTime(23, 59, 59));
  }

  @Override
  public List<SalePeriodResponse> searchForSales(LocalDate dateFrom, LocalDate dateTo) {
    return productRepository.findSalesInPeriod(dateFrom.atStartOfDay(), dateTo.atTime(23, 59, 59));
  }

  private Product get(long id) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    return optionalProduct.isPresent() ? optionalProduct.get() : null;
  }
}

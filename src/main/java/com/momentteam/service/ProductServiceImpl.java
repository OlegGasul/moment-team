package com.momentteam.service;

import com.momentteam.exception.ProductNotFoundException;
import com.momentteam.model.ProductRepository;
import com.momentteam.model.entity.Product;
import com.momentteam.model.entity.Sale;
import com.momentteam.model.report.SalePeriodResponse;
import java.math.BigDecimal;
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
    product.getSales().forEach(sale -> sale.setProduct(product));
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

    List<Sale> sales = productRepository.findSalesInPeriod(productId, dateFrom.atStartOfDay(), dateTo.atTime(23, 59, 59));

    long quantity = sales.stream().mapToLong(Sale::getQuantity).sum();
    BigDecimal amount = sales.stream().map(sale -> sale.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

    return SalePeriodResponse.builder()
        .productId(product.getId())
        .productName(product.getName())
        .quantity(quantity)
        .amount(amount)
        .build();
  }

  private Product get(long id) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    return optionalProduct.isPresent() ? optionalProduct.get() : null;
  }
}

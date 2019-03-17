package com.momentteam.service;

import com.momentteam.model.entity.Product;
import com.momentteam.model.report.SalePeriodResponse;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  Product save(Product product);

  Iterable<Product> findAll();

  Optional<Product> findById(long id);

  SalePeriodResponse searchForSales(long productId, LocalDate dateFrom, LocalDate dateTo);

}

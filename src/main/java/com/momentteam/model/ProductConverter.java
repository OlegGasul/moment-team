package com.momentteam.model;

import com.momentteam.model.dto.ProductDto;
import com.momentteam.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {

  public ProductDto convert(Product product) {
    return ProductDto.builder()
        .id(product.getId())
        .name(product.getName())
        .number(product.getNumber())
        .price(product.getPrice())
        .build();
  }

}

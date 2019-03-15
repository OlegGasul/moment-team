package com.momentteam.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.momentteam.exception.ProductNotFoundException;
import com.momentteam.model.entity.Product;
import com.momentteam.service.ProductService;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping(method = GET)
  public Iterable<Product> getAll() {
    return productService.findAll();
  }

  @RequestMapping(method = POST)
  public Product create(@RequestBody Product product) {
    return productService.save(product);
  }

  @RequestMapping(method = PUT, path = "/{id}")
  public Product update(@PathVariable(value = "id") @NotNull long id, @RequestBody Product product) {
    Optional<Product> optionalProduct = productService.findById(id);
    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException("Product with ID = " + id + " not found");
    }

    Product toSave = Product.builder()
        .id(id)
        .name(product.getName())
        .number(product.getNumber())
        .price(product.getPrice())
        .sales(product.getSales())
        .build();

    return productService.save(toSave);
  }

  @RequestMapping(method = GET, path = "/{id}")
  public Product get(@PathVariable(value = "id") @NotNull long id) {
    Optional<Product> optionalProduct = productService.findById(id);
    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException("Product with ID = " + id + " not found");
    }

    return optionalProduct.get();
  }

}

package com.momentteam.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.momentteam.model.ProductConverter;
import com.momentteam.model.dto.ProductDto;
import com.momentteam.service.ProductService;
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

  @Autowired
  private ProductConverter productConverter;


  @RequestMapping(method = POST, path = "/")
  public ProductDto add(@RequestBody ProductDto productDto) {
    return productConverter.convert(productService.createProduct());
  }

  @RequestMapping(method = GET, path = "/{id}")
  public ProductDto get(@PathVariable(value = "name") @NotNull long id) {
    return productConverter.convert(productService.get(id));
  }

}

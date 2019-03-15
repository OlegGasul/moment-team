package com.momentteam.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.momentteam.model.entity.Product;
import com.momentteam.service.ProductService;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  private ProductService productService;

  @RequestMapping(method = GET, path = "/product/name/{query}")
  public List<Product> get(@PathVariable(value = "query") @NotNull String query) {
    return productService.searchByName(query);
  }


}

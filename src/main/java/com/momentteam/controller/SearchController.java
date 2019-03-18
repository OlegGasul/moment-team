package com.momentteam.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.momentteam.model.ProductSearchDao;
import com.momentteam.model.entity.Sale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

  @Autowired
  private ProductSearchDao productSearchDao;

  @RequestMapping(method = GET, path = "/sale")
  public List<Sale> get() {
    return productSearchDao.searchForSales(null);
  }

}

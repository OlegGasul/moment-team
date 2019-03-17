package com.momentteam.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.momentteam.model.report.SalePeriodResponse;
import com.momentteam.service.ProductService;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

  @Autowired
  private ProductService productService;

  @RequestMapping(method = GET, path = "/product/sales/{id}")
  public SalePeriodResponse get(@PathVariable(value = "id") @NotNull long id,
      @RequestParam(name = "dateFrom")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      LocalDate dateFrom,
      @RequestParam(name = "dateTo")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      LocalDate dateTo) {
    return productService.searchForSales(id, dateFrom, dateTo);
  }

  @RequestMapping(method = GET, path = "/product/sales")
  public List<SalePeriodResponse> get(@RequestParam(name = "dateFrom")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      LocalDate dateFrom,
      @RequestParam(name = "dateTo")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      LocalDate dateTo) {
    return productService.searchForSales(dateFrom, dateTo);
  }

}

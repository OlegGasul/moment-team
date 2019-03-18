package com.momentteam.model.search;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleSearchFilter {

  private LocalDate dateFrom;
  private LocalDate dateTo;

}

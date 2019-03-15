package com.momentteam.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.momentteam.model.entity.Product;
import com.momentteam.service.ProductService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProductService productService;

  @Before
  public void setup() {
    Product product1 = createProduct(1l, "1st", "1", 100);
    Product product2 = createProduct(2l, "2st", "2", 50);
    Product product3 = createProduct(3l, "3st", "3", 120);
    when(productService.findAll()).thenReturn(Lists.newArrayList(product1, product2, product3));

    when(productService.findById(1l)).thenReturn(Optional.of(product1));
    when(productService.findById(2l)).thenReturn(Optional.of(product2));
    when(productService.findById(3l)).thenReturn(Optional.of(product3));

    when(productService.save(any(Product.class))).thenReturn(product1);
  }

  @Test
  public void shouldReturnAllProducts() throws Exception {
    mvc.perform(get("/product")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"id\":1,\"name\":\"1st\",\"number\":\"1\",\"price\":100,\"sales\":[]},{\"id\":2,\"name\":\"2st\",\"number\":\"2\",\"price\":50,\"sales\":[]},{\"id\":3,\"name\":\"3st\",\"number\":\"3\",\"price\":120,\"sales\":[]}]"));
  }

  @Test
  public void shouldReturnProductById() throws Exception {
    mvc.perform(get("/product/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"name\":\"1st\",\"number\":\"1\",\"price\":100,\"sales\":[]}"));

    mvc.perform(get("/product/2")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\":2,\"name\":\"2st\",\"number\":\"2\",\"price\":50,\"sales\":[]}"));

    mvc.perform(get("/product/3")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\":3,\"name\":\"3st\",\"number\":\"3\",\"price\":120,\"sales\":[]}"));
  }

  @Test
  public void shouldSaveNewProduct() throws Exception {
    mvc.perform(post("/product")
        .content("{\"id\":1,\"name\":\"1st\",\"number\":\"1\",\"price\":100,\"sales\":[]}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\":1,\"name\":\"1st\",\"number\":\"1\",\"price\":100,\"sales\":[]}"));
  }

  @Test
  public void shouldReturn404ForNonExistsId() throws Exception {
    mvc.perform(get("/product/4")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  private Product createProduct(long id, String name, String number, double price) {
    return new Product(id, name, number, BigDecimal.valueOf(price), Collections.emptySet());
  }

}

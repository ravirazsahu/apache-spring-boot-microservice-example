package io.github.georgwittberger.microserviceexample.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.georgwittberger.microserviceexample.productservice.product.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
  @Autowired
  private ProductService productService;

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String viewProductsHTML(Model model) {
    model.addAttribute("products", productService.getProducts());
    return "products";
  }
}

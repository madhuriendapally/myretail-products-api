package myretail.products.api.demo.controller;

import myretail.products.api.demo.domain.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getItem(@PathVariable int id) {
        return new Product();
    }

    @GetMapping("/")
    public String getAllItems() {
        return "All Items";
    }
}

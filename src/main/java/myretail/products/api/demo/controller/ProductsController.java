package myretail.products.api.demo.controller;

import lombok.RequiredArgsConstructor;
import myretail.products.api.demo.domain.Products;
import myretail.products.api.demo.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Products> getItem(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @GetMapping("/")
    public List<Products> getAllItems() {
        return productsService.getAllProducts();
    }
}

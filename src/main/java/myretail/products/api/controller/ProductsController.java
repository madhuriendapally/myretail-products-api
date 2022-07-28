package myretail.products.api.controller;

import lombok.RequiredArgsConstructor;
import myretail.products.api.dto.ProductDTO;
import myretail.products.api.service.ProductService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProductDTO getItem(@PathVariable Long id) {
        return productService.getProductById(id);
    }

}

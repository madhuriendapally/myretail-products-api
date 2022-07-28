package myretail.products.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myretail.products.api.domain.Products;
import myretail.products.api.exception.ProductNotFoundException;
import myretail.products.api.repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDBIntegrationService {
    private final ProductsRepository productsRepository;

    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}

package myretail.products.api.service;

import lombok.RequiredArgsConstructor;
import myretail.products.api.domain.Products;
import myretail.products.api.dto.CurrentPriceDTO;
import myretail.products.api.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDBIntegrationService productDBIntegrationService;

    private final RedskyIntegrationService redskyIntegrationService;

    public ProductDTO getProductById(Long id) {
        Products product = productDBIntegrationService.getProductById(id);
        String productName = redskyIntegrationService.getProductDescription(id);
        return new ProductDTO(
                product.getId(),
                productName,
                new CurrentPriceDTO(
                        product.getCurrentPrice().getValue(),
                        product.getCurrentPrice().getCurrencyCode()
                ));
    }

}

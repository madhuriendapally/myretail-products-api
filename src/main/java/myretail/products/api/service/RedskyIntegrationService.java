package myretail.products.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myretail.products.api.generated.redsky.Data;
import myretail.products.api.generated.redsky.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedskyIntegrationService {

    private final WebClient redskyWebClient;

    @Value("${redsky.api.key}")
    protected String redskyAuthKey;

    public String getProductDescription(Long id) {
        Product product = getProductById(id);
        if (product != null && product.item != null && product.item.productDescription != null) {
            return product.item.productDescription.title;
        }
        return null;
    }

    public Product getProductById(Long id) {
        try {
            ResponseEntity<Data> responseEntity = redskyWebClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("key", redskyAuthKey)
                            .queryParam("tcin", id)
                            .build())
                    .retrieve().toEntity(Data.class).block();
            if (responseEntity != null && responseEntity.getBody() != null) {
                return responseEntity.getBody().product;
            }
        } catch (Exception e) {
            //For now taking no further action then logging it. Possible actions could be to throw an exception.
            log.error("Failed to retrieve product details from redsky service for product {} Service call failed with exception", id, e);
        }
        return null;
    }
}

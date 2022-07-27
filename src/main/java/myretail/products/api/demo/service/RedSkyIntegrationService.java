package myretail.products.api.demo.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Data
@RequiredArgsConstructor
public class RedSkyIntegrationService {

    private final WebClient redskyWebClient;

    @Value("${redsky.api.key}")
    protected String redskyAuthKey;

    public Object getProductDescriptionById(Long id) {
        ResponseEntity<Object> responseEntity = redskyWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("key", redskyAuthKey)
                        .queryParam("tcin", id)
                        .build())
                .retrieve().toEntity(Object.class).block();

        return responseEntity.getBody();
    }
}

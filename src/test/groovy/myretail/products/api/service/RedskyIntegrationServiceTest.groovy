package myretail.products.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import myretail.products.api.config.WebClientConfiguration
import myretail.products.api.generated.redsky.Data
import myretail.products.api.generated.redsky.Item
import myretail.products.api.generated.redsky.Product
import myretail.products.api.generated.redsky.ProductDescription
import myretail.products.api.generated.redsky.ProductResponseEntity
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.web.reactive.function.client.WebClient
import spock.lang.Shared
import spock.lang.Specification

@EnableConfigurationProperties
@ContextConfiguration(classes = WebClientConfiguration)
@TestPropertySource(properties = ['redsky.api.url=http://localhost:5555', 'redsky.api.key=mock-key'])
class RedskyIntegrationServiceTest extends Specification {

    RedskyIntegrationService redskyIntegrationService

    @Shared
    MockWebServer mockWebServer


    @Autowired
    @Qualifier("redskyWebClient")
    WebClient webClient

    @Value('${redsky.api.key}')
    String redSkyAuthKey

    ObjectMapper objectMapper = new ObjectMapper()

    void setup() {
        mockWebServer = new MockWebServer()
        redskyIntegrationService = new RedskyIntegrationService(webClient)
        redskyIntegrationService.redskyAuthKey = redSkyAuthKey
        mockWebServer.start(5555)
    }

    void cleanup() {
        mockWebServer.shutdown()
    }

    def "GetProductById returns the product from redsky service when the product is returned"() {
        given:
        String productDescription = 'This is a test product with a title'
        Product actualProduct = getProduct(productDescription)
        ProductResponseEntity productResponseEntity = getProductResponse(actualProduct)

        mockWebServer.enqueue(
                new MockResponse()
                        .setBody(objectMapper.writeValueAsString(productResponseEntity))
                        .addHeader('Content-Type', 'application/json'))
        when:
        Product product = redskyIntegrationService.getProductById(1L)
        then:
        product != null
        product.item.productDescription.title == productDescription

    }

    def "GetProductById returns null when product is not available"() {
        given:
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(HttpStatus.NOT_FOUND.value())
                        .addHeader('Content-Type', 'application/json'))
        when:
        Product product = redskyIntegrationService.getProductById(1L)
        then:
        product == null
    }

    def "GetProductDescription returns the expected product description when the value is present"() {
        given:
        String actualProductDescription = 'Product1'
        Product actualProduct = getProduct(actualProductDescription)
        ProductResponseEntity productResponseEntity = getProductResponse(actualProduct)

        mockWebServer.enqueue(
                new MockResponse()
                        .setBody(objectMapper.writeValueAsString(productResponseEntity))
                        .addHeader('Content-Type', 'application/json'))
        when:
        String productTitle = redskyIntegrationService.getProductDescription(1L)
        then:
        productTitle != null
        productTitle == actualProductDescription
    }

    def "GetProductDescription returns null when product is not available"() {
        given:
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(HttpStatus.NOT_FOUND.value())
                        .addHeader('Content-Type', 'application/json'))
        when:
        String productTitle = redskyIntegrationService.getProductDescription(1L)
        then:
        productTitle == null
    }

    private ProductResponseEntity getProductResponse(Product actualProduct) {
        ProductResponseEntity productResponseEntity = new ProductResponseEntity(
                data: new Data(product:
                        actualProduct))
        productResponseEntity
    }

    private Product getProduct(String productDescription) {
        Product actualProduct = new Product(item:
                new Item(productDescription:
                        new ProductDescription(title:
                                productDescription
                        )))
        actualProduct
    }
}

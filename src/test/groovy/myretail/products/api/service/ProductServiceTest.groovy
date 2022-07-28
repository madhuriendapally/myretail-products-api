package myretail.products.api.service

import myretail.products.api.domain.CurrentPrice
import myretail.products.api.domain.Products
import myretail.products.api.dto.CurrentPriceDTO
import myretail.products.api.dto.ProductDTO
import spock.lang.Specification
import spock.lang.Unroll

class ProductServiceTest extends Specification {
    ProductService productService

    ProductDBIntegrationService productDBIntegrationService = Mock()
    RedskyIntegrationService redskyIntegrationService = Mock()

    void setup() {
        productService = new ProductService(productDBIntegrationService, redskyIntegrationService)
    }

    @Unroll
    def "GetProductById should return expected product"() {
        given:
        BigDecimal price = productPrice
        String currencyCode = 'USD'
        Long productId = 1l
        Products product = new Products(id: productId, currentPrice: new CurrentPrice(value: price, currencyCode: currencyCode))
        String productDescription = productName
        ProductDTO expectedProduct = new ProductDTO(
                id: productId, currentPrice: new CurrentPriceDTO(
                value: price,
                currencyCode: currencyCode), name: productDescription
        )
        when:
        ProductDTO actualProduct = productService.getProductById(1L)
        then:
        1 * productDBIntegrationService.getProductById(1L) >> product
        1 * redskyIntegrationService.getProductDescription(1L) >> productDescription
        0 * _
        assert (expectedProduct == actualProduct)
        where:
        productPrice << [123.45, 0, null]
        productCurrency << ['USD', '', null]
        productName << ['This is a fun product', '', null]

    }
}

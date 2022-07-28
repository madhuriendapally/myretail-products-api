package myretail.products.api.service

import myretail.products.api.domain.CurrentPrice
import myretail.products.api.domain.Products
import myretail.products.api.exception.ProductNotFoundException
import myretail.products.api.repository.ProductsRepository
import spock.lang.Specification

class ProductDBIntegrationServiceTest extends Specification {
    ProductDBIntegrationService productDBIntegrationService

    ProductsRepository productsRepository = Mock()

    void setup() {
        productDBIntegrationService = new ProductDBIntegrationService(productsRepository)
    }

    def "GetProductById should return the expected product"() {
        given:
        Optional<Products> product = Optional.of(new Products(id: 1L, currentPrice: new CurrentPrice(value: 12.54, currencyCode: 'USD')))
        when:
        Products receivedProduct = productDBIntegrationService.getProductById(1L)
        then:
        1 * productsRepository.findById(1L) >> product
        0 * _
        assert product.get() == receivedProduct
    }

    def "GetProductById should throw ProductNotFoundException when the product is not found"() {
        when:
        productDBIntegrationService.getProductById(1L)
        then:
        1 * productsRepository.findById(1L) >> Optional.empty()
        0 * _
        thrown(ProductNotFoundException.class)
    }


}

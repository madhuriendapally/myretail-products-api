package myretail.products.api

import myretail.products.api.controller.HomeController
import myretail.products.api.controller.ProductsController
import myretail.products.api.service.ProductDBIntegrationService
import myretail.products.api.service.RedskyIntegrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextSpec extends Specification {

    @Autowired
    private HomeController homeController

    @Autowired
    private ProductsController productsController

    @Autowired
    private ProductDBIntegrationService productsService

    @Autowired
    private RedskyIntegrationService redSkyIntegrationService

    def "when context is loaded then all expected beans are created"() {
        expect: "the homeController is created"
        homeController
        productsController
        productsService
        redSkyIntegrationService
    }

}

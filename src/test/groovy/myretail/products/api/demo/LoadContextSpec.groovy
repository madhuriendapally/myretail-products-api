package myretail.products.api.demo

import myretail.products.api.demo.controller.HomeController
import myretail.products.api.demo.controller.ProductsController
import myretail.products.api.demo.service.ProductsService
import myretail.products.api.demo.service.RedSkyIntegrationService
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
    private ProductsService productsService

    @Autowired
    private RedSkyIntegrationService redSkyIntegrationService

    def "when context is loaded then all expected beans are created"() {
        expect: "the homeController is created"
        homeController
        productsController
        productsService
        redSkyIntegrationService
    }

}

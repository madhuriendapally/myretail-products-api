package myretail.products.api.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ProductsControllerSpec extends Specification {

    @Autowired
    private MockMvc mvc

    def "when '/api/v1/products/{id}' is invoked it should return a  200 with product details"() {
        expect: "Status is 200 and the returns product details"
        mvc.perform(get("/api/v1/products/1"))
                .andExpect(status().isOk())
                .andReturn()
                .response
    }

}

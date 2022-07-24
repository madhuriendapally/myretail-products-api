package myretail.products.api.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest
@AutoConfigureMockMvc
class HomeControllerSpec extends Specification {

    @Autowired
    private MockMvc mvc

    def "when '/' is invoked it should return a  200 with welcome message"() {
        expect: "Status is 200 and the response is 'Welcome to Madhuri's Retail!!'"
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Welcome to Madhuri's Retail!!"
    }
}


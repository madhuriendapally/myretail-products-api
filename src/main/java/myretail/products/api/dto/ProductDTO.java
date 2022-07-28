package myretail.products.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonRootName("product")
@JsonPropertyOrder({"id", "name", "current_price"})
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    Long id;
    String name;
    @JsonProperty("current_price")
    CurrentPriceDTO currentPrice;
}

package myretail.products.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonRootName("current_price")
@JsonPropertyOrder({"value", "currency_code"})
@NoArgsConstructor
@AllArgsConstructor
public class CurrentPriceDTO {
    Float value;
    @JsonProperty("currency_code")
    String currencyCode;
}

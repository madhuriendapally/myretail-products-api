package myretail.products.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "current_price")
public class CurrentPrice {
    BigDecimal value;
    @Field("currency_code")
    String currencyCode;
}

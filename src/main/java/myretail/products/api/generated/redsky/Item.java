
package myretail.products.api.generated.redsky;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product_description",
    "enrichment",
    "product_classification",
    "primary_brand"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("product_description")
    public ProductDescription productDescription;
    @JsonProperty("enrichment")
    public Enrichment enrichment;
    @JsonProperty("product_classification")
    public ProductClassification productClassification;
    @JsonProperty("primary_brand")
    public PrimaryBrand primaryBrand;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

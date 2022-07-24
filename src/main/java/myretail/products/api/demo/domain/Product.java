package myretail.products.api.demo.domain;

import lombok.Data;

@Data
public class Product {
    long id;
    String name;
    float price;
    String currencyCode;
}

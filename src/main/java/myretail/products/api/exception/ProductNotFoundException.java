package myretail.products.api.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("The product: " + id + " is not found");
    }

}

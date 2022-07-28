package myretail.products.api.repository;

import myretail.products.api.domain.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products, Long> {

}

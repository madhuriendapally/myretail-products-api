package myretail.products.api.demo.repository;

import myretail.products.api.demo.domain.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products, Long> {

}

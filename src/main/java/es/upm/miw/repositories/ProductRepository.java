package es.upm.miw.repositories;

import es.upm.miw.documents.Product;
import es.upm.miw.dtos.output.ProductSearchOutputDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{$and:["
            + "?#{ [0] == null ? { $where : 'true'} : { description : {$regex :[0], $options : 'i'} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { stock : {$gte :[1]} } },"
            + "?#{ [2] == null ? { $where : 'true'} : { minPrice : {$gte :[2]} } },"
            + "?#{ [3] == null ? { $where : 'true'} : { maxPrice : {$lte :[3]} } }"
            + "] }")
    List<ProductSearchOutputDto> findByDescriptionAndStockAndPriceNullSafe(String description, Integer stock, String minPrice, String maxPrice);

    Product findByCode(String code);

    Product findFirstByCodeStartingWithOrderByRegistrationDateDescCodeDesc(String prefix);

}
package com.eze.market.persistance.crud;

import com.eze.market.persistance.entity.Product;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    //Alternativa a QueryMethods
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> getProductsByCategoryOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockLessThanAndStatus(int stockQuantity, boolean status);

}

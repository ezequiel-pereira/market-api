package com.eze.market.domain.repository;

import com.eze.market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProductById(int productId);
    ProductDomain save(ProductDomain productDomain);
    void delete(int productId);
}

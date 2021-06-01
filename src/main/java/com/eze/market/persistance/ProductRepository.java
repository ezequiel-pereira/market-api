package com.eze.market.persistance;

import com.eze.market.domain.ProductDomain;
import com.eze.market.persistance.crud.ProductCrudRepository;
import com.eze.market.persistance.entity.Product;
import com.eze.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository  implements com.eze.market.domain.repository.ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDomain> getAll() {
         List<Product> products = (List<Product>) productCrudRepository.findAll();
         return productMapper.toProductDomain(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.getProductsByCategoryOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProductDomain(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return products.map(p -> productMapper.toProductDomain(p));
    }

    public Optional<List<Product>> getRunningOff(int stockQuantity) {
        return productCrudRepository.findByStockLessThanAndStatus( stockQuantity, true);
    }

    @Override
    public Optional<ProductDomain> getProductById(int productId) {
        return productCrudRepository.findById(productId).map(p -> productMapper.toProductDomain(p));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = productMapper.toProduct(productDomain);
        return productMapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}

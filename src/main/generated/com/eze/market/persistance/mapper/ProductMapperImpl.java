package com.eze.market.persistance.mapper;

import com.eze.market.domain.ProductDomain;
import com.eze.market.persistance.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-16T21:15:39-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDomain toProductDomain(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDomain productDomain = new ProductDomain();

        if ( product.getProductId() != null ) {
            productDomain.setProductId( product.getProductId() );
        }
        if ( product.getPrice() != null ) {
            productDomain.setPrice( product.getPrice() );
        }
        productDomain.setName( product.getName() );
        if ( product.getStatus() != null ) {
            productDomain.setActive( product.getStatus() );
        }
        if ( product.getStock() != null ) {
            productDomain.setStock( product.getStock() );
        }
        if ( product.getCategoryId() != null ) {
            productDomain.setCategoryId( product.getCategoryId() );
        }
        productDomain.setCategoryDomain( categoryMapper.toCategoryDomain( product.getCategory() ) );

        return productDomain;
    }

    @Override
    public List<ProductDomain> toProductDomain(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDomain> list = new ArrayList<ProductDomain>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDomain( product ) );
        }

        return list;
    }

    @Override
    public Product toProduct(ProductDomain productDomain) {
        if ( productDomain == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDomain.getProductId() );
        product.setPrice( productDomain.getPrice() );
        product.setName( productDomain.getName() );
        product.setStock( productDomain.getStock() );
        product.setCategory( categoryMapper.toCategory( productDomain.getCategoryDomain() ) );
        product.setCategoryId( productDomain.getCategoryId() );
        product.setStatus( productDomain.isActive() );

        return product;
    }
}

package com.eze.market.persistance.mapper;

import com.eze.market.domain.PurchaseProductDomain;
import com.eze.market.persistance.entity.PurchaseProducts;
import com.eze.market.persistance.entity.PurchaseProductsPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-16T21:15:39-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class PurchaseProductMapperImpl implements PurchaseProductMapper {

    @Override
    public PurchaseProductDomain toPurchaseProductsDomain(PurchaseProducts purchaseProducts) {
        if ( purchaseProducts == null ) {
            return null;
        }

        PurchaseProductDomain purchaseProductDomain = new PurchaseProductDomain();

        if ( purchaseProducts.getStatus() != null ) {
            purchaseProductDomain.setActive( purchaseProducts.getStatus() );
        }
        if ( purchaseProducts.getQuantity() != null ) {
            purchaseProductDomain.setQuantity( purchaseProducts.getQuantity() );
        }
        Integer saleId = purchaseProductsIdSaleId( purchaseProducts );
        if ( saleId != null ) {
            purchaseProductDomain.setProductId( saleId );
        }
        if ( purchaseProducts.getTotal() != null ) {
            purchaseProductDomain.setTotal( purchaseProducts.getTotal() );
        }

        return purchaseProductDomain;
    }

    @Override
    public PurchaseProducts toPurchaseProducts(PurchaseProductDomain purchaseProductDomain) {
        if ( purchaseProductDomain == null ) {
            return null;
        }

        PurchaseProducts purchaseProducts = new PurchaseProducts();

        purchaseProducts.setId( purchaseProductDomainToPurchaseProductsPK( purchaseProductDomain ) );
        purchaseProducts.setQuantity( purchaseProductDomain.getQuantity() );
        purchaseProducts.setStatus( purchaseProductDomain.isActive() );
        purchaseProducts.setTotal( purchaseProductDomain.getTotal() );

        return purchaseProducts;
    }

    private Integer purchaseProductsIdSaleId(PurchaseProducts purchaseProducts) {
        if ( purchaseProducts == null ) {
            return null;
        }
        PurchaseProductsPK id = purchaseProducts.getId();
        if ( id == null ) {
            return null;
        }
        Integer saleId = id.getSaleId();
        if ( saleId == null ) {
            return null;
        }
        return saleId;
    }

    protected PurchaseProductsPK purchaseProductDomainToPurchaseProductsPK(PurchaseProductDomain purchaseProductDomain) {
        if ( purchaseProductDomain == null ) {
            return null;
        }

        PurchaseProductsPK purchaseProductsPK = new PurchaseProductsPK();

        purchaseProductsPK.setSaleId( purchaseProductDomain.getProductId() );

        return purchaseProductsPK;
    }
}

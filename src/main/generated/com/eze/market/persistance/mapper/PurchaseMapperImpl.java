package com.eze.market.persistance.mapper;

import com.eze.market.domain.PurchaseDomain;
import com.eze.market.domain.PurchaseProductDomain;
import com.eze.market.persistance.entity.Purchase;
import com.eze.market.persistance.entity.PurchaseProducts;
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
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseProductMapper purchaseProductMapper;

    @Override
    public PurchaseDomain toPurchaseDomain(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseDomain purchaseDomain = new PurchaseDomain();

        purchaseDomain.setPurchaseDate( purchase.getDate() );
        purchaseDomain.setClientId( purchase.getClientId() );
        if ( purchase.getPurchaseId() != null ) {
            purchaseDomain.setPurchaseId( purchase.getPurchaseId() );
        }
        purchaseDomain.setPaymentMethod( purchase.getPaymentMethod() );
        purchaseDomain.setComment( purchase.getNote() );
        purchaseDomain.setItems( purchaseProductsListToPurchaseProductDomainList( purchase.getPurchaseProducts() ) );
        if ( purchase.getStatus() != null ) {
            purchaseDomain.setStatus( Boolean.parseBoolean( purchase.getStatus() ) );
        }

        return purchaseDomain;
    }

    @Override
    public List<PurchaseDomain> toPurchaseDomainList(List<Purchase> purchaseList) {
        if ( purchaseList == null ) {
            return null;
        }

        List<PurchaseDomain> list = new ArrayList<PurchaseDomain>( purchaseList.size() );
        for ( Purchase purchase : purchaseList ) {
            list.add( toPurchaseDomain( purchase ) );
        }

        return list;
    }

    @Override
    public Purchase toPurchase(PurchaseDomain purchaseDomain) {
        if ( purchaseDomain == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setDate( purchaseDomain.getPurchaseDate() );
        purchase.setNote( purchaseDomain.getComment() );
        purchase.setClientId( purchaseDomain.getClientId() );
        purchase.setPurchaseId( purchaseDomain.getPurchaseId() );
        purchase.setPaymentMethod( purchaseDomain.getPaymentMethod() );
        purchase.setPurchaseProducts( purchaseProductDomainListToPurchaseProductsList( purchaseDomain.getItems() ) );
        if ( purchaseDomain.getStatus() != null ) {
            purchase.setStatus( String.valueOf( purchaseDomain.getStatus() ) );
        }

        return purchase;
    }

    protected List<PurchaseProductDomain> purchaseProductsListToPurchaseProductDomainList(List<PurchaseProducts> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseProductDomain> list1 = new ArrayList<PurchaseProductDomain>( list.size() );
        for ( PurchaseProducts purchaseProducts : list ) {
            list1.add( purchaseProductMapper.toPurchaseProductsDomain( purchaseProducts ) );
        }

        return list1;
    }

    protected List<PurchaseProducts> purchaseProductDomainListToPurchaseProductsList(List<PurchaseProductDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseProducts> list1 = new ArrayList<PurchaseProducts>( list.size() );
        for ( PurchaseProductDomain purchaseProductDomain : list ) {
            list1.add( purchaseProductMapper.toPurchaseProducts( purchaseProductDomain ) );
        }

        return list1;
    }
}

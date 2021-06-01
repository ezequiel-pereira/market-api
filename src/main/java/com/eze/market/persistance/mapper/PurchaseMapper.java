package com.eze.market.persistance.mapper;

import com.eze.market.domain.PurchaseDomain;
import com.eze.market.persistance.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses ={PurchaseProductMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "purchaseId",target = "purchaseId"),
            @Mapping(source = "clientId",target = "clientId"),
            @Mapping(source = "date",target = "purchaseDate"),
            @Mapping(source = "paymentMethod",target = "paymentMethod"),
            @Mapping(source = "note", target = "comment"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "purchaseProducts", target = "items")
    })
    PurchaseDomain toPurchaseDomain(Purchase purchase);

    List<PurchaseDomain> toPurchaseDomainList(List<Purchase> purchaseList);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "customer", ignore = true),
    })
    Purchase toPurchase(PurchaseDomain purchaseDomain);
}

package com.eze.market.persistance.mapper;

import com.eze.market.domain.PurchaseProductDomain;
import com.eze.market.persistance.entity.PurchaseProducts;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseProductMapper {

    @Mappings({
            @Mapping(source = "id.saleId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            //@Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseProductDomain toPurchaseProductsDomain(PurchaseProducts purchaseProducts);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    PurchaseProducts toPurchaseProducts(PurchaseProductDomain purchaseProductDomain);
}

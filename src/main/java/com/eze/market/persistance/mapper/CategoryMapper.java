package com.eze.market.persistance.mapper;

import com.eze.market.domain.CategoryDomain;
import com.eze.market.persistance.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source ="categoryId", target = "categoryId"),
            @Mapping(source ="description", target = "category"),
            @Mapping(source ="state", target = "active")
    })
    CategoryDomain toCategoryDomain(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDomain categoryDomain);
}

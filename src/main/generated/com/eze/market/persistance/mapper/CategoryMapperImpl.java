package com.eze.market.persistance.mapper;

import com.eze.market.domain.CategoryDomain;
import com.eze.market.persistance.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-16T21:15:39-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDomain toCategoryDomain(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDomain categoryDomain = new CategoryDomain();

        if ( category.getState() != null ) {
            categoryDomain.setActive( category.getState() );
        }
        categoryDomain.setCategory( category.getDescription() );
        if ( category.getCategoryId() != null ) {
            categoryDomain.setCategoryId( category.getCategoryId() );
        }

        return categoryDomain;
    }

    @Override
    public Category toCategory(CategoryDomain categoryDomain) {
        if ( categoryDomain == null ) {
            return null;
        }

        Category category = new Category();

        category.setDescription( categoryDomain.getCategory() );
        category.setState( categoryDomain.isActive() );
        category.setCategoryId( categoryDomain.getCategoryId() );

        return category;
    }
}

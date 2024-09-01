package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.service;

import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model.Catalog;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model.Category;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.repository.CatalogRepository;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response.CatalogDataResponse;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response.CategoryDataResponse;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.request.CatalogDataRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoryDataResponse> getAllCategories() {

       var listOfCats =   List.of(Category.builder()
               .id(UUID.randomUUID().toString())
               .name("Phones")
               .build());

        return convertPojoToResponse(listOfCats);


    }

    private List<CategoryDataResponse> convertPojoToResponse(List<Category> catalogs) {

        return catalogs.stream().map(i -> modelMapper.map(i, CategoryDataResponse.class)).collect(Collectors.toList());

    }
}

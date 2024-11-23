package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.service;

import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model.Catalog;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.repository.CatalogRepository;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response.CatalogDataResponse;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util.ImagePicker;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.request.CatalogDataRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util.PhoneNamePicker.getName;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ImagePicker imagePicker;

    public List<CatalogDataResponse> getItemsByCategory(CatalogDataRequest catalogDataRequest) {

        Pageable pageable = PageRequest.of(catalogDataRequest.getOffset(), catalogDataRequest.getLimit());
        List<Catalog> catalogs = catalogRepository.findAll(pageable).toList();
        return convertPojoToResponse(catalogs);
    }

    private List<CatalogDataResponse> convertPojoToResponse(List<Catalog> catalogs) {
//        var result = catalogs.stream().peek(i -> i.setId(UUID.randomUUID().toString())).collect(Collectors.toList());

        return catalogs.stream().map(i -> modelMapper.map(i, CatalogDataResponse.class)).collect(Collectors.toList());

    }
}

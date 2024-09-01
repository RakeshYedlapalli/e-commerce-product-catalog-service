package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.controller;


import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model.Catalog;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.repository.CatalogRepository;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response.CatalogDataResponse;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response.CategoryDataResponse;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.service.CatalogService;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.service.CategoryService;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util.ImagePicker;
import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.request.CatalogDataRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util.PhoneNamePicker.getName;

@RestController
@RequestMapping("/catalog")
@CrossOrigin
public class CatalogController {

    @Autowired
    CatalogService itemService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ImagePicker imagePicker;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatalogRepository catalogRepository;

    @PostMapping("/items")
    public ResponseEntity<List<CatalogDataResponse>> items(@RequestBody CatalogDataRequest catalogDataRequest) throws InterruptedException {

            Thread.sleep(2000);
            return new ResponseEntity<>(itemService.getItemsByCategory(catalogDataRequest), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDataResponse>> categories() {

        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }


    @GetMapping("/pushAllData")
    public void postAllData() {


        var listOfCats = new ArrayList<Catalog>();
        for (int i = 0; i < 1000; i++) {
            listOfCats.add(Catalog.builder().id(UUID.randomUUID().toString())
                    .category("smart phones")
                    .image(imagePicker.pickRandomFile("/Users/rakesh/Documents/my-github-repositories/remote-rakesh-yedlapalli-git-workspace/spring-projects/e-commeerce-application-development/e-commerce-product-catalog-service/src/main/resources/static"))
                    .name(getName())
                    .price(30003d)
                    .rating(3.4)
                    .numberOfRatings(2003).build());
        }

        catalogRepository.saveAll(listOfCats);


//             convertPojoToResponse(listOfCats);
    }


}

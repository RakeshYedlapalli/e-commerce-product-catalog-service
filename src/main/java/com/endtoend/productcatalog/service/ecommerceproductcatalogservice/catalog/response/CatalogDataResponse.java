package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDataResponse {
    private String id;
    private String name;
    private Double price;
    private String image;
    private double rating;
    private int numberOfRatings;
}


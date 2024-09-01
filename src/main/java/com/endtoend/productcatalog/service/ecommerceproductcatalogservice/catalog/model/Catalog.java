package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "catalogs")
@Entity
public class Catalog {

    @Id
    private String id;
    private String name;
    private String category;
    private Double price;
    private String image;
    private double rating;
    @Column(name = "number_of_rating")
    private int numberOfRatings;
}
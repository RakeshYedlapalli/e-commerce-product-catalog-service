package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model;

import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categories")
public class Category {

    @Id
    private String id;
    private String name;
}

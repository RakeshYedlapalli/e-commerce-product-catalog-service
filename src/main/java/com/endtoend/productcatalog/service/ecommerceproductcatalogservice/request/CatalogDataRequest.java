package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDataRequest {
    private String name;
    private String category;
    private int limit;
    private int offset;
}


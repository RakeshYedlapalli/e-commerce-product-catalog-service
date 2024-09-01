package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.repository;

import com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatalogRepository extends PagingAndSortingRepository<Catalog, String>, JpaRepository<Catalog, String> {
}

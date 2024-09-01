package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanMappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/images")
@CrossOrigin
public class MediaController {

    @GetMapping("/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        try {
            // Load the image file from the classpath
            Resource resource = new ClassPathResource("static/" + imageName);
            InputStream inputStream = resource.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();

            // Set headers to indicate image content type and length
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(imageBytes.length);

            // Return the image bytes with appropriate headers
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            // Image not found or other IO error occurred
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

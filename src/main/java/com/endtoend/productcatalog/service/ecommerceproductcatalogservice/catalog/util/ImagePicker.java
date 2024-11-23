package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class ImagePicker {

    private final ResourceLoader resourceLoader;

    public ImagePicker(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // Method to pick a random file name from the specified directory
    public static String pickRandomFile(String directoryPath) {
        Path dir = Paths.get(directoryPath);

        try (var stream = Files.walk(dir)) {
            // Filter directories and get a list of all files in the directory
            var files = stream
                    .filter(Files::isRegularFile)
                    .toList();

            if (files.isEmpty()) {
                // If the directory is empty, return null
                return null;
            }

            // Select a random index within the range of files
            Random random = new Random();
            int randomIndex = random.nextInt(files.size());

            // Get the randomly selected file name
            Path randomFile = files.get(randomIndex);

            // Return the file name as a string
            return randomFile.getFileName().toString();
        } catch (IOException e) {
            // Handle any exceptions that occur while accessing the directory
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] pickRandomFileArray(String directoryPath) {
        Path dir = Paths.get(directoryPath);

        try (var stream = Files.walk(dir)) {
            // Filter directories and get a list of all files in the directory
            var files = stream
                    .filter(Files::isRegularFile)
                    .toList();

            if (files.isEmpty()) {
                // If the directory is empty, return null
                return null;
            }

            // Select a random index within the range of files
            Random random = new Random();
            int randomIndex = random.nextInt(files.size());

            // Get the randomly selected file name
            Path randomFile = files.get(randomIndex);

            // Return the file name as a string
            var fileName =  randomFile.getFileName().toString();
            Resource resource = new ClassPathResource("static/" + fileName);
            InputStream inputStream = resource.getInputStream();
            return  inputStream.readAllBytes();
        } catch (IOException e) {
            // Handle any exceptions that occur while accessing the directory
            e.printStackTrace();
            return null;
        }
    }
}

package com.endtoend.productcatalog.service.ecommerceproductcatalogservice.catalog.util;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhoneNamePicker {


   public static String getName() {
       List<String> iphoneModels = new ArrayList<>();
       iphoneModels.add("iPhone");
       iphoneModels.add("iPhone 3G");
       iphoneModels.add("iPhone 3GS");
       iphoneModels.add("iPhone 4");
       iphoneModels.add("iPhone 4S");
       iphoneModels.add("iPhone 5");
       iphoneModels.add("iPhone 5C");
       iphoneModels.add("iPhone 5S");
       iphoneModels.add("iPhone 6");
       iphoneModels.add("iPhone 6 Plus");
       iphoneModels.add("iPhone 6S");
       iphoneModels.add("iPhone 6S Plus");
       iphoneModels.add("iPhone SE (1st generation)");
       iphoneModels.add("iPhone 7");
       iphoneModels.add("iPhone 7 Plus");
       iphoneModels.add("iPhone 8");
       iphoneModels.add("iPhone 8 Plus");
       iphoneModels.add("iPhone X");
       iphoneModels.add("iPhone XR");
       iphoneModels.add("iPhone XS");
       iphoneModels.add("iPhone XS Max");
       iphoneModels.add("iPhone 11");
       iphoneModels.add("iPhone 11 Pro");
       iphoneModels.add("iPhone 11 Pro Max");
       iphoneModels.add("iPhone SE (2nd generation)");
       iphoneModels.add("iPhone 12 mini");
       iphoneModels.add("iPhone 12");
       iphoneModels.add("iPhone 12 Pro");
       iphoneModels.add("iPhone 12 Pro Max");


       Random random = new Random();
       int randomIndex = random.nextInt(iphoneModels.size());

       // Get the randomly selected file name
       return iphoneModels.get(randomIndex);
   }
}

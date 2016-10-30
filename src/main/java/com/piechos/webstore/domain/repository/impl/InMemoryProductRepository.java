package com.piechos.webstore.domain.repository.impl;


import com.piechos.webstore.domain.Product;
import com.piechos.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym wyświetlaczem o rozdzielczości 640x1136 " +
                "oraz 8-megapikselowym aparatem");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptopDell = new Product("P1235", "Dell Inspiration", new BigDecimal(700));
        laptopDell.setDescription("Dell inspiration, 14-calowy laptop (czarny) z procesore Intel Core 3. generacji");
        laptopDell.setCategory("Laptop");
        laptopDell.setManufacturer("Dell");
        laptopDell.setUnitsInStock(1000);

        Product tabletNexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tabletNexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem " +
                "Qualcomm Snapdragon S4 Pro");
        tabletNexus.setCategory("Tablet");
        tabletNexus.setManufacturer("Google");
        tabletNexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptopDell);
        listOfProducts.add(tabletNexus);
    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }
}

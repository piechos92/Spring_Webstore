package com.piechos.webstore.domain.repository.impl;

import com.piechos.webstore.domain.Product;
import com.piechos.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

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

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for(Product product : listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for(Product product : listOfProducts) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product : listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if(criterias.contains("category")) {
            for(String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high) {
        Set<Product> productsByPrice = new HashSet<>();
        for(Product product : listOfProducts) {
            if(product.getUnitPrice().compareTo(low) >= 0 && product.getUnitPrice().compareTo(high) <= 0) {
                productsByPrice.add(product);
            }
        }
        return productsByPrice;
    }
}

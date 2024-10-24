package com.demo.Tienda.services;

import com.demo.Tienda.entities.ProductsEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    private final List<ProductsEntity> products;

    public ProductsService() {
        products = new ArrayList<>();
        products.add(new ProductsEntity(UUID.randomUUID(), "Laptop", 3500000));
        products.add(new ProductsEntity(UUID.randomUUID(), "Smartphone", 1200000));
        products.add(new ProductsEntity(UUID.randomUUID(), "Tablet", 850000));
        products.add(new ProductsEntity(UUID.randomUUID(), "Smartwatch", 600000));
        products.add(new ProductsEntity(UUID.randomUUID(), "Monitor", 950000));
    }

    public List<ProductsEntity> getAllProducts() {
        return products;
    }

    public Optional<ProductsEntity> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public UUID createProduct(ProductsEntity product) {
        product.setId(UUID.randomUUID());
        products.add(product);
        return product.getId();
    }

    public Optional<ProductsEntity> updateProduct(UUID id, ProductsEntity updateProduct) {
        Optional<ProductsEntity> existingProduct = getProductById(id);
        existingProduct.ifPresent(product -> {
            product.setNombre(updateProduct.getNombre());
            product.setPrecio(updateProduct.getPrecio());
        });
        return existingProduct;
    }

    public boolean deleteProduct(UUID id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}

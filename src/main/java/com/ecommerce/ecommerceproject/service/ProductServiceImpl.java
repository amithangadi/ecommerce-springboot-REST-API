package com.ecommerce.ecommerceproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceproject.entity.Product;
import com.ecommerce.ecommerceproject.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {  

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product dbProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        dbProduct.setName(product.getName());
        dbProduct.setDescription(product.getDescription());
        dbProduct.setPrice(product.getPrice());
        dbProduct.setStock(product.getStock());
        dbProduct.setImgUrl(product.getImgUrl());
        dbProduct.setCategory(product.getCategory());

        return repository.save(dbProduct);
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> getByCategory(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}

package com.nmb.productservice.service;

import com.nmb.productservice.exceptions.ProductNotFoundException;
import com.nmb.productservice.model.Product;
import com.nmb.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id %s not found".formatted(id)));
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(String id, Product productDetails) {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());

        return repository.save(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);

        repository.delete(product);
    }
}

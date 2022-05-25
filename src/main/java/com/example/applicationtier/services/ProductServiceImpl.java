package com.example.applicationtier.services;

import com.example.applicationtier.Contracts.ProductService;
import com.example.applicationtier.models.Product;
import com.example.applicationtier.networking.ProductClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductClient productClient;

    public ProductServiceImpl() throws IOException {
        this.productClient = new ProductClient();
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    @Override
    public Product getProductById(int id) throws IOException {
        return productClient.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productClient.addProduct(product);
    }

    @Override
    public void deleteProductByIdAsync(int id) {
        productClient.deleteProductByIdAsync(id);
    }

    @Override
    public void updateProductAsync(Product product) {
        productClient.updateProductAsync(product);
    }
}

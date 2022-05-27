package com.example.applicationtier.models;

import com.example.applicationtier.entities.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface ProductModel {
    public ArrayList<Product> getAllProducts();
    public Product getProductById(int id) throws IOException;
    public void addProduct(Product product);
    public void deleteProductByIdAsync(int id);
    public void updateProductAsync(Product product);
}

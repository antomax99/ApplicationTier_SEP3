package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface ProductService {
    public ArrayList<Product> getAllProducts();
    public Product getProductById(int id) throws IOException;
    public void addProduct(Product product);
    public void deleteProductByIdAsync(int id);
    public void updateProductAsync(Product product);
}

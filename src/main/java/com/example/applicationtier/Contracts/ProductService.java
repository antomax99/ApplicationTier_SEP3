package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id) throws IOException;
    public void addProduct(Product product);
    public void addProductToOrder(Product product, int orderId);
    public void deleteProductByIdAsync(int id);
    public void updateProductAsync(Product product);

}

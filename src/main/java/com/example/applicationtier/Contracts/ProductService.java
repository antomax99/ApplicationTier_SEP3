package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ProductService {
     List<Product> getAllProducts();
     Product getProductById(int id) throws IOException;
     void addProduct(Product product);
     void addProductToOrder(Product product, int orderId);
     void deleteProductByIdAsync(int id);
     void updateProductAsync(Product product);

}

package com.example.applicationtier.networking;

import com.example.applicationtier.entities.Product;
import com.example.applicationtier.entities.User;
import com.example.applicationtier.models.ProductModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductClient implements ProductModel {

    private Socket socket;
    private final String host = "localhost";
    private final int port = 2913;

    private PrintWriter out;
    private BufferedReader in;

    private Gson gson;

    public ProductClient() throws IOException {
        socket = new Socket(host, port);
        gson = new Gson();
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


    @Override
    public List<Product> getAllProducts() {
        out.println("get products");
        String productsAsJson = null;
        try {
            productsAsJson = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This parses your JSON
        Product[] productsFound = new Gson().fromJson(productsAsJson, Product[].class);


        return List.of(productsFound);
    }

    @Override
    public Product getProductById(int id) throws IOException {
        out.println("get product by id");
        String idAsJson = gson.toJson(id);
        out.println(idAsJson);
        String productAsJson = in.readLine();
        Product productFound = gson.fromJson(productAsJson,Product.class);
        return productFound;
    }

    @Override
    public void addProduct(Product product) {
        out.println("add product");
        String productAsJson = gson.toJson(product);
        out.println(productAsJson);
    }

    @Override
    public void deleteProductByIdAsync(int id) {
        out.println("delete product by id");
        String idAsJson = gson.toJson(id);
        out.println(idAsJson);
    }

    @Override
    public void updateProductAsync(Product product) {
        out.println("update product");
        String productAsJson = gson.toJson(product);
        out.println(productAsJson);
    }
}

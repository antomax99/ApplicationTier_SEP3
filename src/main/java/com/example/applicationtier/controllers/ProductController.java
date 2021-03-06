package com.example.applicationtier.controllers;

import com.example.applicationtier.entities.Order;
import com.example.applicationtier.entities.Product;
import com.example.applicationtier.Contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllProducts() throws IOException {
        System.out.println("getAllProducts ON CONTROLLER");
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return new ResponseEntity("product created", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}/retrieve", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductById(@PathVariable int id) throws IOException {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@RequestBody Product product)
    {
        productService.updateProductAsync(product);
        return new ResponseEntity("product update successful", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteProductById(@PathVariable int id)
    {
        productService.deleteProductByIdAsync(id);
        return new ResponseEntity("deleted product successful",HttpStatus.OK);
    }
}

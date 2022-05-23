package com.example.applicationtier.controllers;

import com.example.applicationtier.models.Order;
import com.example.applicationtier.models.Product;
import com.example.applicationtier.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return new ResponseEntity("product created", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductById(@PathVariable int id) throws IOException {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @RequestMapping(value = "/products/update", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@RequestBody Product product)
    {
        productService.updateProductAsync(product);
        return new ResponseEntity("product update successful", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProductById(@PathVariable int id)
    {
        productService.deleteProductByIdAsync(id);
        return new ResponseEntity("deleted product successful",HttpStatus.OK);
    }
}

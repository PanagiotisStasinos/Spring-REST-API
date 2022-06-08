package com.example.demo;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    ProductService productservice;

    @CrossOrigin(origins = "http://localhost:3000")

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(){
        System.out.println("get mes 0");
        return new ResponseEntity<List<Product>>(productservice.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        System.out.println("id mes 0");
        if(productservice.getProduct(id) == null){
            System.out.println("id mes 1");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(productservice.getProduct(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Product> createProduct(@RequestParam(value = "id") Long id,
                                             @RequestParam(value = "name") String name, @RequestParam(value = "price") Integer price) {
        Product temp_prod = productservice.createProduct(id, name, price);

        if(temp_prod == null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(temp_prod, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        Integer temp = productservice.deleteProduct(id);

        if(temp == -1){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity modifyProductPrice(@PathVariable("id") Long id) {
        Integer temp = productservice.modifyProductPrice(id); //increases value by one

        if(temp == -1){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    Integer test(){
        System.out.println("lalala");
        return -15;
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    @CrossOrigin
    public ResponseEntity<Resource> image() throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                "C:\\Users\\panai\\OneDrive\\Desktop\\index.jpg"
        )));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}

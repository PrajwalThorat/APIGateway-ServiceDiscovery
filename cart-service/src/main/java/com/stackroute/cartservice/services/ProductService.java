package com.stackroute.cartservice.services;

import com.stackroute.cartservice.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(int productId);
    List<Product> listAllProducts();
    Product getProductById(int productId);

}

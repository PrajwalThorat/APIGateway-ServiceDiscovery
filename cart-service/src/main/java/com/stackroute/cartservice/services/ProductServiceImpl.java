package com.stackroute.cartservice.services;

import com.stackroute.cartservice.model.Product;
import com.stackroute.cartservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product deleteProduct(int productId) {
        Product product = null;
        if (productRepo.findById(productId).isPresent()){
            product = productRepo.findById(productId).get();
            productRepo.deleteById(productId);
        }
        return product;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepo.findById(productId).get();
    }
}

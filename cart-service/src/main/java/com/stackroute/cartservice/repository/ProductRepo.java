package com.stackroute.cartservice.repository;


import com.stackroute.cartservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product , Integer> {
    List<Product> findByPrice()
}

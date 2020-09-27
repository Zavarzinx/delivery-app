package com.delivery.deliveryapp.repository;

import com.delivery.deliveryapp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

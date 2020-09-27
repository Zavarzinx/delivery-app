package com.delivery.deliveryapp.repository;

import com.delivery.deliveryapp.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}

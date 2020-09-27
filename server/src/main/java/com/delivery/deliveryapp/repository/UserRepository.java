package com.delivery.deliveryapp.repository;

import com.delivery.deliveryapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

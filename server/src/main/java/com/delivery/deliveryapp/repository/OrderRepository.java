package com.delivery.deliveryapp.repository;

import com.delivery.deliveryapp.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

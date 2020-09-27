package com.delivery.deliveryapp.service;

import com.delivery.deliveryapp.entity.Order;
import com.delivery.deliveryapp.entity.Product;

import java.util.List;

public interface OrderService {

    Order createOrder(List<Product> products);

    Order save(Order order);

    Order cancel(Order order);
}

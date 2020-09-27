package com.delivery.deliveryapp.service.impl;

import com.delivery.deliveryapp.entity.Order;
import com.delivery.deliveryapp.entity.OrderStatus;
import com.delivery.deliveryapp.entity.Product;
import com.delivery.deliveryapp.repository.OrderRepository;
import com.delivery.deliveryapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(List<Product> products) {
        Order order = Order.builder()
                .status(OrderStatus.CREATED)
                .products(products)
                .deliveryPrice(0) //
                .totalSum(products.stream().map(Product::getPrice).reduce(Double::sum).get())
                .build();
        return orderRepository.save(order);
    }

    @Override
    public Order save(Order order) {
       return orderRepository.save(order);
    }

    @Override
    public Order cancel(Order order) {
        order.setCanceled(true);
        order.setEndTime(LocalDateTime.now());
        return order;
    }
}

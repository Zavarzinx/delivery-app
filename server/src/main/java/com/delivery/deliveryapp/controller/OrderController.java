package com.delivery.deliveryapp.controller;

import com.delivery.deliveryapp.entity.Order;
import com.delivery.deliveryapp.entity.Product;
import com.delivery.deliveryapp.repository.OrderRepository;
import com.delivery.deliveryapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody List<Product> products){
        return new ResponseEntity<>(orderService.createOrder(products), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable ("id") Order order) {
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable("id") Order order){
        return new ResponseEntity<>(orderService.cancel(order), HttpStatus.OK);
    }

    @PostMapping("/{id}/addProduct")
    public ResponseEntity<Order> addProductToOrder(@PathVariable("id") Order order, Product product){
        order.getProducts().add(product);
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
    }

}

package com.delivery.deliveryapp.controller;

import com.delivery.deliveryapp.entity.Order;
import com.delivery.deliveryapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

//    @GetMapping("/orders")
//    public List<Order> getUserOrders() {
//
//    }
}

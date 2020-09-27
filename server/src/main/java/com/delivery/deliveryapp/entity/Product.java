package com.delivery.deliveryapp.entity;

import lombok.Data;

@Data
public class Product {

    private String id;

    private double price;

    private String name;

    private long quantity;

    private Description description;
}

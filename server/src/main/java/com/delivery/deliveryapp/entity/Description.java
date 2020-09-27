package com.delivery.deliveryapp.entity;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
public class Description {
    @Id
    private String id;

    private String description;

    private String country;

    private String manufacturer;

    @Enumerated(EnumType.STRING)
    private WeightType weightType;

    private long weight;
}

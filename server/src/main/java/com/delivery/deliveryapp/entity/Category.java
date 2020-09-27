package com.delivery.deliveryapp.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Set;

@Document
@Data
public class Category {
    @Id
    private String id;

    private Set<Product> products;
}

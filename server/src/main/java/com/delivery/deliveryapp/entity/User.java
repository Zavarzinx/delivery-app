package com.delivery.deliveryapp.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Set;

@Document
@Data
public class User {

    @Id
    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private Set<Order> orders;

}

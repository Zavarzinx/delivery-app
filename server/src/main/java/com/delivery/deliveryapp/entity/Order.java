package com.delivery.deliveryapp.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private List<Product> products;

    @CreatedDate
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime deliverToTime;

    private long deliveryPrice;

    private double totalSum;

    private boolean isCanceled;
}

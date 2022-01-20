package com.test.rewards.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private long orderId;

    private String customerId;

    private double totalAmount;

    private String orderedDate;
}

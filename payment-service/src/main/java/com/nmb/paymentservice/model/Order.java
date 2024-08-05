package com.nmb.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    private Long id;

    private String userId;

    private List<OrderItem> items;

    private String status;

    private double totalAmount;
}

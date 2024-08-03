package com.nmb.orderservice.service;

import com.nmb.orderservice.exceptions.OrderNotFoundException;
import com.nmb.orderservice.model.Order;
import com.nmb.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "new-orders";

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order with id %n not found".formatted(id)));
    }

    public Order createOrder(Order order) {
        order.setStatus("PENDING");
        Order savedOrder = repository.save(order);
        kafkaTemplate.send(TOPIC, savedOrder);
        return savedOrder;
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);

        order.setStatus(status);

        return repository.save(order);
    }
}

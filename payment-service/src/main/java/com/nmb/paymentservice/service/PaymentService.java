package com.nmb.paymentservice.service;

import com.nmb.paymentservice.exceptions.PaymentNotFoundException;
import com.nmb.paymentservice.model.Order;
import com.nmb.paymentservice.model.Payment;
import com.nmb.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    private final KafkaTemplate<String, Payment> kafkaTemplate;

    private static final String PAYMENT_TOPIC = "payment-events";

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with id %n not found".formatted(id)));
    }

    @KafkaListener(topics = "new-orders", groupId = "payment-service-group")
    public void processPayment(Order order) {
        Payment payment = new Payment();

        payment.setOrderId(order.getId());
        payment.setAmount(order.getTotalAmount());
        payment.setStatus("PROCESSING");
        payment.setTimestamp(LocalDateTime.now());

        payment = repository.save(payment);

        // Simulate payment processing
        try {
            Thread.sleep(2000); // Simulating external payment gateway call
            payment.setStatus("COMPLETED");
        } catch (InterruptedException e) {
            payment.setStatus("FAILED");
        }

        payment = repository.save(payment);
        kafkaTemplate.send(PAYMENT_TOPIC, payment);
    }
}

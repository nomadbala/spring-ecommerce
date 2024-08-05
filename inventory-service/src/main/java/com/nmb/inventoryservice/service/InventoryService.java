package com.nmb.inventoryservice.service;

import com.nmb.inventoryservice.exceptions.InventoryItemNotFoundException;
import com.nmb.inventoryservice.model.InventoryItem;
import com.nmb.inventoryservice.model.Order;
import com.nmb.inventoryservice.model.OrderItem;
import com.nmb.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    public List<InventoryItem> getAllInventoryItems() {
        return repository.findAll();
    }

    public InventoryItem getInventoryItemById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new InventoryItemNotFoundException("Inventory item with id %s not found".formatted(id)));
    }

    public InventoryItem updateInventoryItem(InventoryItem item) {
        return repository.save(item);
    }

    @KafkaListener(topics = "new-orders", groupId = "inventory-service-group")
    public void processOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            InventoryItem inventoryItem = getInventoryItemById(item.getProductId());

            inventoryItem.setQuantity(inventoryItem.getQuantity() - item.getQuantity());
            repository.save(inventoryItem);
        }
    }
}

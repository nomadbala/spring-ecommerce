package com.nmb.inventoryservice.service;

import com.nmb.inventoryservice.model.InventoryItem;
import com.nmb.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
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
        return repository.findById(id).orElse(null);
    }
}

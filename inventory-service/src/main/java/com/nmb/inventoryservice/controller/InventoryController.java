package com.nmb.inventoryservice.controller;

import com.nmb.inventoryservice.model.InventoryItem;
import com.nmb.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private InventoryService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryItem> getAllInventoryItems() {
        return service.getAllInventoryItems();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryItem getInventoryItemById(@PathVariable String productId) {
        return service.getInventoryItemById(productId);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryItem updateInventoryItem(@PathVariable String productId, @RequestBody InventoryItem item) {
        item.setProductId(productId);
        return service.updateInventoryItem(item);
    }
}

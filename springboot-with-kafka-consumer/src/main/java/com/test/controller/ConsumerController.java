package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.OrderEvent;
import com.test.dto.UserEvent;
import com.test.service.ConsumerService;

@RestController
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/consumed/users")
    public List<UserEvent> getUserEvents() {
        return consumerService.getUserEvents();
    }

    @GetMapping("/consumed/orders")
    public List<OrderEvent> getOrderEvents() {
        return consumerService.getOrderEvents();
    }
}
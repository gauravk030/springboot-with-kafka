package com.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.OrderEvent;
import com.test.dto.UserEvent;
import com.test.service.ProducerService;

@RestController
@RequestMapping("/events")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> publishUser(@RequestBody UserEvent event) {
        producerService.sendUserEvent(event);
        return ResponseEntity.ok("User event published");
    }

    @PostMapping("/order")
    public ResponseEntity<String> publishOrder(@RequestBody OrderEvent event) {
        producerService.sendOrderEvent(event);
        return ResponseEntity.ok("Order event published");
    }
}

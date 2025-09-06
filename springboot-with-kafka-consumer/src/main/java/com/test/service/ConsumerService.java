package com.test.service;

import com.test.dto.UserEvent;
import com.test.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    private final List<UserEvent> userEvents = new ArrayList<>();
    private final List<OrderEvent> orderEvents = new ArrayList<>();

    @KafkaListener(topics = "${myapp.kafka.topic.user}", groupId = "appB-group")
    public void consumeUser(UserEvent event) {
        System.out.println("Consumed User event: " + event.getName() + " -> " + event.getAction());
        userEvents.add(event);
    }

    @KafkaListener(topics = "${myapp.kafka.topic.order}", groupId = "appB-group")
    public void consumeOrder(OrderEvent event) {
        System.out.println("Consumed Order event: " + event.getOrderId() + " -> " + event.getProduct());
        orderEvents.add(event);
    }

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public List<OrderEvent> getOrderEvents() {
        return orderEvents;
    }
}

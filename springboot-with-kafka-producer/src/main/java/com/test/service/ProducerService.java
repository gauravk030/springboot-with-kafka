package com.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.test.dto.OrderEvent;
import com.test.dto.UserEvent;

@Service
public class ProducerService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Value("${myapp.kafka.topic.user}")
	private String userTopic;

	@Value("${myapp.kafka.topic.order}")
	private String orderTopic;

	public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	public void sendUserEvent(UserEvent event) {
		kafkaTemplate.send(userTopic, event);
	}

	public void sendOrderEvent(OrderEvent event) {
		kafkaTemplate.send(orderTopic, event);
	}

}

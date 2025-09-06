package com.test.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic myKafkaTest() {
        return new NewTopic("myKafkaTest", 3, (short) 1);
    }
}

package com.myoluk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String service, String level, String message) {
        String sendMessage = service + "|" + level + "|" + message;
        kafkaTemplate.send(topic, sendMessage);
    }
}

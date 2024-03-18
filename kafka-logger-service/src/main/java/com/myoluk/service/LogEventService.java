package com.myoluk.service;

import com.myoluk.entity.LogEvent;
import com.myoluk.repository.LogEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogEventService {

    private final LogEventRepository logEventRepository;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {

        String[] messages = message.split("\\|");

        LogEvent logEvent = new LogEvent();
        logEvent.setTimestamp(LocalDateTime.now());
        logEvent.setService(messages[0]);
        logEvent.setLevel(messages[1]);
        logEvent.setMessage(messages[2]);

        logEventRepository.save(logEvent);
    }
}

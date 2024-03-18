package com.myoluk.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KafkaProperties {

    @Value("${kafka.topic}")
    private String topic;

    @Value("${spring.application.name}")
    private String service;
}

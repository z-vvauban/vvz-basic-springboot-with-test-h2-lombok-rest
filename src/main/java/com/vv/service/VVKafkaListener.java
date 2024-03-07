package com.vv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VVKafkaListener {

    @KafkaListener( topics = "vvz59", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
        log.error("Received Message in group foo: " + message);
    }

}

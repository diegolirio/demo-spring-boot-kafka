package com.example.demokafka.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class ConsumerMessage {

    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "${message.topic.name}", groupId = "${group.myStudy}")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'myStudy': " + message);
        latch.countDown();
    }

}

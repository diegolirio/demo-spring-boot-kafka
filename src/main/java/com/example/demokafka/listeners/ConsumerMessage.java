package com.example.demokafka.listeners;

import com.example.demokafka.config.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class ConsumerMessage {

    private CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    private KafkaProperties kafkaProperties;

    @KafkaListener(topics = "${kafka.messageTopicRequest}", groupId = "${kafka.groupMyStudy}")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'myStudy': " + message);
        latch.countDown();
    }

}

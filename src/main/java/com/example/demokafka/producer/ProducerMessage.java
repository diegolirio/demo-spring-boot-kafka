package com.example.demokafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.messageTopicRequest}")
    private String topicName;

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }

}

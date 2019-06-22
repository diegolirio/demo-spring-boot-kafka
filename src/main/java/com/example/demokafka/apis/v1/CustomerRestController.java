package com.example.demokafka.apis.v1;

import com.example.demokafka.config.KafkaProperties;
import com.example.demokafka.producer.ProducerMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/apis/v1/customers")
public class CustomerRestController {

    @Autowired
    private ProducerMessage producerMessage;

    @GetMapping
    public String getCustomers() {
        return "Diego Lirio";
    }

    @GetMapping("/producer")
    public void producer(String message) {
        producerMessage.sendMessage("Hello = " + message);
    }

    @GetMapping("/future")
    public String future(String name) throws ExecutionException, InterruptedException {
        return this.producerMessage.sendFutureReturnHelloName(name);
    }


}

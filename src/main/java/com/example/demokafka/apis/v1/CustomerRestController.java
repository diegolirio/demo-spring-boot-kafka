package com.example.demokafka.apis.v1;

import com.example.demokafka.producer.ProducerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

package com.example.demokafka.producer;

import com.example.demokafka.config.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class ProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;

    public void sendMessage(String msg) {
        kafkaTemplate.send(kafkaProperties.getMessageTopicRequest(), msg);
    }

    public String sendFutureReturnHelloName(String name) throws ExecutionException, InterruptedException {

        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>(kafkaProperties.getMessageTopicRequest(), name);

        record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, kafkaProperties.getMessageTopicReply().getBytes()));

        RequestReplyFuture<String, String, String> sendAndReceive = replyingKafkaTemplate.sendAndReceive(record);

        SendResult<String, String> sendResult = sendAndReceive.getSendFuture().get();

        //sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));

        ConsumerRecord<String, String> consumerRecord = sendAndReceive.get();

        return consumerRecord.value();
    }

}

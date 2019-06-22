package com.example.demokafka.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka")
public class KafkaProperties {

    private String bootstrapAddress;
    private String messageTopicRequest;
    private String messageTopicReply;
    private String groupMyStudy;

}

package com.spring.kafka.springkafkamongodb.kafkaconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic getNewTopicForJson(){
        return TopicBuilder.name("kafka_demo").build();
    }
}

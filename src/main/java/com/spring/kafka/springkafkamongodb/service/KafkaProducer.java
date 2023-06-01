package com.spring.kafka.springkafkamongodb.service;

import com.spring.kafka.springkafkamongodb.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String , User> kafkaTemplate;


    public void sendMessage(User user){
        LOGGER.info(String.format("======== Producing message: -> %s========", user.toString()));
        kafkaTemplate.send("kafka_demo",user);
    }
}

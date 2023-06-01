package com.spring.kafka.springkafkamongodb.service;

import com.spring.kafka.springkafkamongodb.entity.User;
import com.spring.kafka.springkafkamongodb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private UserRepository userRepository;
    private static  final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "kafka_demo" , groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("User message received  -> %s" , user.toString()));
        userRepository.save(user);
    }
}

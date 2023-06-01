package com.spring.kafka.springkafkamongodb.controller;

import com.spring.kafka.springkafkamongodb.entity.User;
import com.spring.kafka.springkafkamongodb.repository.UserRepository;
import com.spring.kafka.springkafkamongodb.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka/user")
public class UserController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<String> produce(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("User added successfully!!!");
    }

    @GetMapping
    public List<User> consume(){
        List<User> users = userRepository.findAll();
        return users;
    }
}

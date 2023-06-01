package com.spring.kafka.springkafkamongodb.repository;
import com.spring.kafka.springkafkamongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String > {
}

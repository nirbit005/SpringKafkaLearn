package com.demo.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

import com.demo.models.UserEmbed;

@Service
public class Consumer {

	private static final String TOPIC = "test";
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = TOPIC, groupId = "group_id", concurrency = "10")
 //   public void consume(UserEmbed message) throws IOException {  ---> One can get direct published message. 
    public void consume(ConsumerRecord rec) throws IOException {
    
    	UserEmbed val = (UserEmbed) rec.value();
    	System.out.println("Topic- " + rec.topic() +" -- " + "Partition- " + rec.partition() + " -- " +
    									"Key- " + rec.key() + " Thread ID - " + Thread.currentThread().getId());    	
        logger.info(String.format("#### -> Consumed message -> %s", val));
    }

    
    @Bean
    public NewTopic test() {
        return TopicBuilder.name("test")
            .partitions(10)
            .replicas(2)
            .build();
    }
}

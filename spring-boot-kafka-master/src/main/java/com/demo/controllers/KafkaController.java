package com.demo.controllers;

import com.demo.engine.Producer;
import com.demo.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping( "/publish")
//    public String sendMessageToKafkaTopic(@RequestParam("message") User message) {
     public String sendMessageToKafkaTopic(@RequestBody User user) {
    	this.producer.sendMessage(user);
        return "Message Published";
    }
}

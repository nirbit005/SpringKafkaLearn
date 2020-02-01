package com.demo.engine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.demo.models.OtherDetails;
import com.demo.models.User;
import com.demo.models.UserDto;
import com.demo.models.UserEmbed;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String, UserEmbed> kafkaTemplate;

    public void sendMessage(User usrDetail) {
    	
    	LocalDate doj = LocalDate.now();
    	LocalDateTime txndt = LocalDateTime.now();
    	OtherDetails odtl = new OtherDetails(doj, txndt, "Kolkata, Nayabad");
  /*  Working....	
    	Map<String, String> usrProfZoneResponsib = new HashMap<>();
    	usrProfZoneResponsib.put("Manager", "RanciZone");
    	usrProfZoneResponsib.put("Auditor", "PatnaZone");
    	usrProfZoneResponsib.put("SytemArchi", "KolkataZone");
    	System.out.println("doj , txndt -> " + doj +"," +txndt);
    	UserDto usrdto = new UserDto(usrDetail.getName(), usrDetail.getDept(), usrDetail.getSalary(),
    								doj, txndt,usrProfZoneResponsib);
        logger.info(String.format("#### -> Producing message -> %s", usrdto));
   */
        UserEmbed usrembed = new UserEmbed(usrDetail.getName(), usrDetail.getDept(), usrDetail.getSalary(),
        		"R&D and Design", odtl);
        
        logger.info(String.format("#### -> Producing message -> %s", usrembed));
        
   //     this.kafkaTemplate.send(TOPIC, usrembed); --> Single request, fire and forget.
   
   //Async call
        
        for(int i = 0; i < 13; i++) {
        	//ListenableFuture<SendResult<String, UserEmbed>> a = 
        	this.kafkaTemplate.send(TOPIC, "key"+i, usrembed)
        	 .addCallback(new ListenableFutureCallback<SendResult<String, UserEmbed>>() {

        	        @Override
        	        public void onSuccess(SendResult<String, UserEmbed> result) {
        	         //   handleSuccess(data);
        	        	System.out.println("Data Writen In Partition - " + result.getRecordMetadata().partition() + " Message -" +
        	        			usrembed);
        	        }

        	        @Override
        	        public void onFailure(Throwable ex) {
        	         //   handleFailure(data, record, ex);
        	        	logger.error("Err writing data {} and err is {}", usrembed, ex);
        	        	
        	        }

        	    });
        	
        	
        }
    }
    
}

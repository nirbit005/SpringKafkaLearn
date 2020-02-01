package com.demo.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.demo.models.UserEmbed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class UserEmbedDesrializer implements Deserializer<UserEmbed>{

	  @Override 
	  public void configure(Map<String, ?> arg0, boolean arg1) {
	  }
	  
	  @Override
	  public UserEmbed deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper()
	    							.registerModule(new ParameterNamesModule())
	    							.registerModule(new Jdk8Module())
	    							.registerModule(new JavaTimeModule()); // new module, NOT JSR310Module;
	    UserEmbed user = null;
	    try {
	      user = mapper.readValue(arg1, UserEmbed.class);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return user;
	  }
	  
	  @Override 
	  public void close() {
	  }
	
}

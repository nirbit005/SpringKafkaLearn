package com.demo.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.demo.models.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class UserDtoSerializer implements Serializer<UserDto> {


	  @Override 
	  public void configure(Map<String, ?> map, boolean b) {
		  
	  }
	  
	  @Override 
	  public byte[] serialize(String arg0, UserDto arg1) {
	    byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper()
	    									.registerModule(new ParameterNamesModule())
	    									.registerModule(new Jdk8Module())
	    									.registerModule(new JavaTimeModule()); // new module, NOT JSR310Module;
	    try {
	      retVal = objectMapper.writeValueAsString(arg1).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	  }
	  
	  @Override 
	  public void close() {
	  }
	  
	
}

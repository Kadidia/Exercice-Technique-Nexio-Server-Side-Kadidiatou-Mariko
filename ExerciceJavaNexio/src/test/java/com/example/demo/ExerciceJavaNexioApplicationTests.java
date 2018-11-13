package com.example.demo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciceJavaNexioApplicationTests {

	protected MockMvc dataMvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	protected void setUp() {
		dataMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	protected String convertToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T ConvertFromJson(String json, Class<T> c)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, c);
	   }
	   
	@Test
	public void contextLoads() {
	}

}

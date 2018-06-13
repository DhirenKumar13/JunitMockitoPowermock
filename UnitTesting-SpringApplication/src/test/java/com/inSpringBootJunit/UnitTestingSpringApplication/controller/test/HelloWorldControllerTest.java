package com.inSpringBootJunit.UnitTestingSpringApplication.controller.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.inSpringBootJunit.UnitTestingSpringApplication.controller.HelloWorldController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		// calling hello-world
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/helloworld")
									  .accept(MediaType.APPLICATION_JSON);
		
		MvcResult responseFromController = mockMvc.perform(requestBuilder)
												  .andExpect(status().isOk())
												  .andExpect(content().string("Hello World"))
												  .andReturn();
		
		assertEquals("Hello World" , responseFromController.getResponse().getContentAsString());
	}
	
}

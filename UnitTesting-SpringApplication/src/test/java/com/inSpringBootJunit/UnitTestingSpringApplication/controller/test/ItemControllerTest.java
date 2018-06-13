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

import com.inSpringBootJunit.UnitTestingSpringApplication.controller.ItemController;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		// calling hello-world
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/dummy-item")
									  .accept(MediaType.APPLICATION_JSON);
		
		MvcResult responseFromController = mockMvc.perform(requestBuilder)
												  .andExpect(status().isOk())
												  .andExpect(content().string("{\"id\":1,\"name\":\"iPhone x\",\"price\":98500,\"quantity\":2}"))
												  .andReturn();
		
		assertEquals("{\"id\":1,\"name\":\"iPhone x\",\"price\":98500,\"quantity\":2}" , responseFromController.getResponse().getContentAsString());
	}
	
	@Test
	public void helloWorld_basicJson() throws Exception {
		// calling hello-world
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/dummy-item")
									  .accept(MediaType.APPLICATION_JSON);
		
		MvcResult responseFromController = mockMvc.perform(requestBuilder)
												  .andExpect(status().isOk())
												  .andExpect(content().json("{\"id\":1,\"name\":\"iPhone x\",\"price\":98500,\"quantity\":2}"))
												  .andReturn();
		
		assertEquals("{\"id\":1,\"name\":\"iPhone x\",\"price\":98500,\"quantity\":2}" , responseFromController.getResponse().getContentAsString());
	}
	
}

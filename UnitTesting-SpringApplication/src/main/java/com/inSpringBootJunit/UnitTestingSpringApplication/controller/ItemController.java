package com.inSpringBootJunit.UnitTestingSpringApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inSpringBootJunit.UnitTestingSpringApplication.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"iPhone x",98500,2);
	}
	
}

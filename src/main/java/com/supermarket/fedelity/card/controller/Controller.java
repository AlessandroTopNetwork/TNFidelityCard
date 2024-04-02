package com.supermarket.fedelity.card.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class Controller { // controller masetr crud of consumer and affliate card
	
	@GetMapping(value = "/consumer")
	public String getConsumerAndCard() {
		return "test";
	}
	
	@PostMapping(value = "/consumer")
	public String registerCard() {
		return "";
	}
	
	@PutMapping(value = "/consumer")
	public String modifyConsumer() {
		return "test";
	}
	
	@DeleteMapping(value = "/consumer")
	public String deleteConsumer() {
		return "";
	}

}

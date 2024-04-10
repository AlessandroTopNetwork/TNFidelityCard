package com.supermarket.fedelity.card.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ControllerAd {
	
	@ExceptionHandler
	public String printError(Exception ex) {
		System.out.println("test error");
		return ex.getMessage();
	}
	
	@GetMapping(value = "/error")
	public String showError(Exception ex) {
		System.out.println("test error");
		return ex.getMessage();
	}

}

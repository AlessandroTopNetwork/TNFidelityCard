package com.supermarket.fedelity.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.serviceinterface.ServiceCliente;

@RestController
//@RequestMapping("/api")
public class Controller { // controller masetr crud of consumer and affliate card
	
	@Autowired
	private ServiceCliente serviceCliente;
	
	@GetMapping(value = "/consumers")
	public List<Cliente> getConsumerAndCard() {
		return serviceCliente.getListClienti();
	}
	
	@GetMapping(value = "/consumer/{id_cliente}")
	public String getConsumerAndCard(@PathVariable long id_cliente) {
		return "test";
	}
	
	@PostMapping(value = "/consumer")
	public Cliente registerCard(@RequestBody Cliente cliente) {
		return serviceCliente.createCliente(cliente);
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

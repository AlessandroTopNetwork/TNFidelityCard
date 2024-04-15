package com.supermarket.fedelity.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.fedelity.card.dto.request.cliente.ClienteRequest;
import com.supermarket.fedelity.card.service.ClienteService;

@RestController
@RequestMapping(value = "/customerservice")
public class ControllerConsumer { // controller masetr crud of consumer and affliate card
	
	@Autowired
	private ClienteService serviceCliente;
	
	@GetMapping(value = "/consumers")
	public List<ClienteRequest> getConsumerAndCard() throws Exception {
		return serviceCliente.getListClienti();
	}
	
	@GetMapping(value = "/consumer/{id}")
	public ClienteRequest getConsumerAndCard(@PathVariable long id) throws Exception {
		return serviceCliente.findById(id);
	}
	
	@GetMapping(value = "/consumers/{numeroTessera}")
	public List<ClienteRequest> getConsumerAndCardByIdCard(@PathVariable String numeroTessera) throws Exception {
		return serviceCliente.getListClientiFindByNumeroCarta(numeroTessera);
	}
	
	@PostMapping(value = "/consumer")
	public ClienteRequest registerCard(@RequestBody ClienteRequest cliente) throws Exception {
		return serviceCliente.createCliente(cliente);
	}
	
	@PutMapping(value = "/consumer")
	public String modifyConsumer() {
		return "test";
	}
	
	@DeleteMapping(value = "/consumer/{idIdentifier}")
	public String deleteConsumer(@PathVariable String idIdentifier) {
		serviceCliente.deleteCliente(idIdentifier);
		return "test";
	}

}

package com.supermarket.fedelity.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.jpa.ClienteJPARepository;
import com.supermarket.fedelity.card.serviceinterface.ServiceCliente;

@Service
public class ServiceClienteImpl implements ServiceCliente {
	
	@Autowired
	private ClienteJPARepository clienteRepository;
	
	public List<Cliente> getListClienti(){ // override metodo preso dall'interfaccia
		return clienteRepository.findAll();
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}

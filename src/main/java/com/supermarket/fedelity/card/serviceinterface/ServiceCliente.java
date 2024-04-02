package com.supermarket.fedelity.card.serviceinterface;

import java.util.List;

import com.supermarket.fedelity.card.entity.Cliente;

public interface ServiceCliente {
	
	List<Cliente> getListClienti();
	
	Cliente createCliente(Cliente cliente);

}

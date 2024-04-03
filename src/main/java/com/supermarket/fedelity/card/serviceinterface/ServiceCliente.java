package com.supermarket.fedelity.card.serviceinterface;

import java.util.List;

import com.supermarket.fedelity.card.dto.ClienteResource;

public interface ServiceCliente {
	
	List<ClienteResource> getListClienti() throws Exception;
	
	ClienteResource createCliente(ClienteResource cliente) throws Exception;
	
	ClienteResource findById(long id) throws Exception;

}

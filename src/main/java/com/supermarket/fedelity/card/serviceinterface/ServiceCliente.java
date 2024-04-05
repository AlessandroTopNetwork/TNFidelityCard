package com.supermarket.fedelity.card.serviceinterface;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.ClienteRequest;

public interface ServiceCliente {
	
	List<ClienteRequest> getListClienti() throws Exception;
	
	List<ClienteRequest> getListClientiFindByNumeroCarta(String numeroCarta) throws Exception;
	
	ClienteRequest createCliente(ClienteRequest cliente) throws Exception;
	
	ClienteRequest findById(long id) throws Exception;

}

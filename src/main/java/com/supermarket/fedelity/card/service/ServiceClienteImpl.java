package com.supermarket.fedelity.card.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.ClienteRequest;
import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.factory.ClienteFactory;
import com.supermarket.fedelity.card.jpa.ClienteJPARepository;
import com.supermarket.fedelity.card.jpa.FedelityCardJPARepository;
import com.supermarket.fedelity.card.serviceinterface.ServiceCliente;

@Service
public class ServiceClienteImpl extends BaseService implements ServiceCliente {

	@Autowired
	private ClienteJPARepository clienteRepository;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardRepository;

	@Autowired
	private ClienteFactory clienteFactory;

	@Override
	public List<ClienteRequest> getListClienti() throws Exception {
		log.info("call getListCliente");
		List<Cliente> listEntity = clienteRepository.findAll();
		List<ClienteRequest> listRequest = clienteFactory.entityToRequest(listEntity);
		log.info("end getListCliente");
		return listRequest;
	}

	@Override
	public ClienteRequest createCliente(ClienteRequest clienteRequest) throws Exception {
		log.info("call createCliente");
		Cliente cliente = clienteFactory.requestToEntity(clienteRequest); // convert request from end point to entity
		cliente.setDataTesseramento(OffsetDateTime.now());
		cliente.getCartaFedelta().setDataCreazioneTessera(OffsetDateTime.now());
		fedelityCardRepository.save(cliente.getCartaFedelta());
		clienteRepository.save(cliente);
		cliente.getCartaFedelta().getClienti().add(cliente); // add un nuovo cliente alla lista già esistente
		fedelityCardRepository.save(cliente.getCartaFedelta());
		log.info("end createCliente");
		return clienteRequest; // return cliente request
	}

	@Override
	public ClienteRequest findById(long id) throws Exception {
		log.info("call findById");
		Cliente cliente = clienteRepository.findById(id);
		return clienteFactory.entityToRequest(cliente);
	}

	@Override
	public List<ClienteRequest> getListClientiFindByNumeroCarta(String numeroTessera) throws Exception {
		log.info("call getListClienteFindByNumeroCarta");
		List<Cliente> listEntity = clienteRepository.findByCartaFedeltaNumeroTessera(numeroTessera);
		List<ClienteRequest> listRequest = clienteFactory.entityToRequest(listEntity);
//		log.info("end getListClienteFindByNumeroCarta");
		return listRequest;
	}

}

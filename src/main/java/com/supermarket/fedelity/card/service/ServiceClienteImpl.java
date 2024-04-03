package com.supermarket.fedelity.card.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.ClienteResource;
import com.supermarket.fedelity.card.dto.FedelityCardResource;
import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.factory.ClienteFactory;
import com.supermarket.fedelity.card.jpa.ClienteJPARepository;
import com.supermarket.fedelity.card.jpa.FedelityCardJPARepository;
import com.supermarket.fedelity.card.serviceinterface.ServiceCliente;

import jakarta.transaction.Transactional;

@Service
public class ServiceClienteImpl extends BaseService implements ServiceCliente {

	@Autowired
	private ClienteJPARepository clienteRepository;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardRepository;

	@Autowired
	private ClienteFactory clienteFactory;

	@Override
	public List<ClienteResource> getListClienti() {
		log.info("call getListCliente");
		List<Cliente> listEntity = clienteRepository.findAll();
		List<ClienteResource> listResource = clienteFactory.entityToResource(listEntity);
		log.info("end getListCliente");
		return listResource;
	}

	@Override
	public ClienteResource createCliente(ClienteResource clienteResource) {
		log.info("call createCliente");
		Cliente cliente = clienteFactory.resourceToEntity(clienteResource);
		cliente.setDataTesseramento(OffsetDateTime.now());
		cliente.getFedelityCard().setDataCreazioneTessera(OffsetDateTime.now());
		fedelityCardRepository.save(cliente.getFedelityCard());
		clienteRepository.save(cliente); // convert resource from end point to entity
		log.info("end createCliente");
		return clienteResource; // return cliente resource
	}

	@Override
	public ClienteResource findById(long id) {
		log.info("call findById");
		Cliente cliente = clienteRepository.findById(id);
		return clienteFactory.entityToResource(cliente);
	}

}

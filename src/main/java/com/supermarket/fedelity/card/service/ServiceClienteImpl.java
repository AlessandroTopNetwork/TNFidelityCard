package com.supermarket.fedelity.card.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.ClienteResource;
import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.factory.ConvertEntityResource;
import com.supermarket.fedelity.card.jpa.ClienteJPARepository;
import com.supermarket.fedelity.card.serviceinterface.ServiceCliente;

@Service
public class ServiceClienteImpl implements ServiceCliente {
	
	@Autowired
	private ClienteJPARepository clienteRepository;
	
	@Autowired
	private ConvertEntityResource convert;
	
	@Override
	public List<ClienteResource> getListClienti() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		   List<Cliente> listEntity = clienteRepository.findAll();
		    List<ClienteResource> listResource = new ArrayList<>();

		    // Converte ogni entità Cliente in un oggetto ClienteResource
		    for (Cliente cliente : listEntity) {
		        ClienteResource resource = (ClienteResource) convert.entityToResource(cliente, ClienteResource.class);
		        listResource.add(resource);
		    }
		return listResource;
	}

	@Override
	public ClienteResource createCliente(ClienteResource cliente) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		clienteRepository.save((Cliente) convert.resourceToEntity(cliente, Cliente.class)); // convert resource to entity
		return cliente; // return cliente resource
	}

	@Override
	public ClienteResource findById(long id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Cliente cliente = clienteRepository.findById(id);
		return (ClienteResource) convert.entityToResource(cliente, ClienteResource.class);
	}

}

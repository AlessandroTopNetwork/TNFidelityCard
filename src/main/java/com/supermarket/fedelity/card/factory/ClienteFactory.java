package com.supermarket.fedelity.card.factory;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.ClienteResource;
import com.supermarket.fedelity.card.dto.ErrorResource;
import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.entity.ErrorEntity;

import io.micrometer.common.util.StringUtils;

@Component
public class ClienteFactory {

	@Autowired
	private FedelityCardFactory fedelityCardFactory;

	public ClienteResource entityToResource(Cliente cliente) {

		ClienteResource clienteResource = new ClienteResource();
		if (null == cliente) {
			clienteResource.setError(new ErrorResource());
			clienteResource.getError().setError("record not found 404");
			clienteResource.getError().setDescription("no comment");
		} else if (null != cliente.getError()) { // se record in errore setto solo quest'ultimo
			if (!"".equalsIgnoreCase(cliente.getError().getError())) {
				clienteResource.setError(new ErrorResource());
				clienteResource.getError().setError(cliente.getError().getError());
				clienteResource.getError().setDescription(cliente.getError().getDescription());
			}
		} else {
			clienteResource.setNome(cliente.getNome());
			clienteResource.setCognome(cliente.getCognome());
			clienteResource.setDataTesseramento(cliente.getDataTesseramento().toString());
			clienteResource.setEmail(cliente.getEmail());
			clienteResource.setFedelityCard(fedelityCardFactory.entityToResource(cliente.getFedelityCard()));
			clienteResource.setIndirizzo(cliente.getIndirizzo());
			clienteResource.setNumeroTelefono(cliente.getNumeroTelefono());
			clienteResource.setNumeroTessera(cliente.getNumeroTessera());
			clienteResource.setStoriciAcquisti(cliente.getStoriciAcquisti());
		}

		return clienteResource;

	}

	public List<ClienteResource> entityToResource(List<Cliente> clienti) {

		List<ClienteResource> listClienteResource = new ArrayList<ClienteResource>();

		for (Cliente cliente : clienti) {
			listClienteResource.add(entityToResource(cliente));
		}

		return listClienteResource;

	}

	public Cliente resourceToEntity(ClienteResource clienteResource) {
		Cliente cliente = new Cliente();
		if (null == clienteResource || null != clienteResource.getError()) { // se record in errore setto solo
																				// quest'ultimo
			if (!"".equalsIgnoreCase(clienteResource.getError().getError())) {
				cliente.setError(new ErrorEntity());
				cliente.getError().setError(clienteResource.getError().getError());
				cliente.getError().setDescription(clienteResource.getError().getDescription());
			}
		} else {
			cliente.setNome(clienteResource.getNome());
			cliente.setCognome(clienteResource.getCognome());
			cliente.setDataTesseramento(StringUtils.isNotEmpty(clienteResource.getDataTesseramento()) ? OffsetDateTime.parse(clienteResource.getDataTesseramento()) : null);
			cliente.setEmail(clienteResource.getEmail());
			cliente.setFedelityCard(fedelityCardFactory.resourceToEntity(clienteResource.getFedelityCard()));
			cliente.setIndirizzo(clienteResource.getIndirizzo());
			cliente.setNumeroTelefono(clienteResource.getNumeroTelefono());
			cliente.setNumeroTessera(clienteResource.getNumeroTessera());
			cliente.setStoriciAcquisti(clienteResource.getStoriciAcquisti());
		}
		return cliente;
	}

	public List<Cliente> resourceToEntity(List<ClienteResource> clienti) {

		List<Cliente> listCr = new ArrayList<Cliente>();

		for (ClienteResource clienteResource : clienti) {
			listCr.add(resourceToEntity(clienteResource));
		}

		return listCr;

	}

}

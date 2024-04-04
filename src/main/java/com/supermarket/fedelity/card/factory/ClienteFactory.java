package com.supermarket.fedelity.card.factory;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.ClienteRequest;
import com.supermarket.fedelity.card.entity.Cliente;
import com.supermarket.fedelity.card.entity.TipoCliente;
import com.supermarket.fedelity.card.jpa.TipoClienteJPARepository;

import io.micrometer.common.util.StringUtils;

@Component
public class ClienteFactory {

	@Autowired
	private FedelityCardFactory fedelityCardFactory;
	
	@Autowired
	private TipoClienteJPARepository tipoClienteRepository;

	public ClienteRequest entityToRequest(Cliente cliente) throws Exception {

		ClienteRequest clienteRequest = new ClienteRequest();
		if (null == cliente) {
			throw new Exception();
		} else {
			clienteRequest.setNome(cliente.getNome());
			clienteRequest.setCognome(cliente.getCognome());
			clienteRequest.setDataTesseramento(null !=cliente.getDataTesseramento() ? cliente.getDataTesseramento().toString() : null);
			clienteRequest.setEmail(cliente.getEmail());
			clienteRequest.setFedelityCard(fedelityCardFactory.entityToRequest(cliente.getFedelityCard()));
			clienteRequest.setIndirizzo(cliente.getIndirizzo());
			clienteRequest.setNumeroTelefono(cliente.getNumeroTelefono());
			clienteRequest.setNumeroTessera(cliente.getNumeroTessera());
			clienteRequest.setStoriciAcquisti(cliente.getStoriciAcquisti());
		}

		return clienteRequest;

	}

	public List<ClienteRequest> entityToRequest(List<Cliente> clienti) throws Exception {

		List<ClienteRequest> listClienteRequest = new ArrayList<ClienteRequest>();

		for (Cliente cliente : clienti) {
			listClienteRequest.add(entityToRequest(cliente));
		}

		return listClienteRequest;

	}

	public Cliente requestToEntity(ClienteRequest clienteRequest) throws Exception {
		Cliente cliente = new Cliente();
		if (null == clienteRequest) {
			throw new Exception();
		} else {
			cliente.setNome(clienteRequest.getNome());
			cliente.setCognome(clienteRequest.getCognome());
			cliente.setDataTesseramento(StringUtils.isNotEmpty(clienteRequest.getDataTesseramento()) ? OffsetDateTime.parse(clienteRequest.getDataTesseramento()) : null);
			cliente.setEmail(clienteRequest.getEmail());
			cliente.setFedelityCard(fedelityCardFactory.requestToEntity(clienteRequest.getFedelityCard()));
			cliente.setIndirizzo(clienteRequest.getIndirizzo());
			cliente.setNumeroTelefono(clienteRequest.getNumeroTelefono());
			cliente.setNumeroTessera(clienteRequest.getNumeroTessera());
			cliente.setStoriciAcquisti(clienteRequest.getStoriciAcquisti());
			Optional<TipoCliente> tipoCliente = tipoClienteRepository.findByTipoCliente(clienteRequest.getTipoCliente().name());
			if(tipoCliente.isPresent()) {
				cliente.setTipoCliente(tipoCliente.get());
			}
			
		}
		return cliente;
	}

	public List<Cliente> requestToEntity(List<ClienteRequest> clienti) throws Exception {

		List<Cliente> listCr = new ArrayList<Cliente>();

		for (ClienteRequest clienteRequest : clienti) {
			listCr.add(requestToEntity(clienteRequest));
		}

		return listCr;

	}

}

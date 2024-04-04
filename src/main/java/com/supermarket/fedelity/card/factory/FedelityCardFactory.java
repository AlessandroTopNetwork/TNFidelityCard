package com.supermarket.fedelity.card.factory;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.FedelityCard;
import com.supermarket.fedelity.card.jpa.PuntoVenditaRepository;

@Component
public class FedelityCardFactory {

	@Lazy // per evitare la riconssione vistio che abbiamo un istanza di fedelitycardfactory in cleintefacotry
	@Autowired
	private ClienteFactory clienteFactory;
	
	@Autowired
	private PuntoVenditaRepository puntoVenditaRepository;

	public FedelityCardRequest entityToRequest(FedelityCard card) throws Exception { // TODO to response not request

		FedelityCardRequest request = new FedelityCardRequest();

		if (null == card) {
			throw new Exception();
		} else {

			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
				request.setCliente(clienteFactory.entityToRequest(card.getClienti()));
			}
			request.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? card.getDataCreazioneTessera().toString() : null);
			request.setPuntoVenditaNome(card.getPuntoVendita().get(0).getNomePuntoVendita());
			request.setNumeroTessera(card.getNumeroTessera());
			request.setPunti(card.getPunti());
		}

		return request;
	}
	
	public FedelityCard requestToEntity(FedelityCardRequest card) throws Exception {

		FedelityCard entity = new FedelityCard();
		
		if (null == card) {
			throw new Exception();
		} else {

//			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
//				request.setCliente(card.getClienti().get(0).clienteToRequest(card.getClienti()));
//			}
			entity.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? OffsetDateTime.parse(card.getDataCreazioneTessera()) : null);
//			entity.setPuntoVendita(card.getPuntoVendita().get(0).getNomePuntoVendita()); // TODO
			entity.setNumeroTessera(card.getNumeroTessera());
			entity.setPunti(card.getPunti());
		}

		return entity;
	}
	
}

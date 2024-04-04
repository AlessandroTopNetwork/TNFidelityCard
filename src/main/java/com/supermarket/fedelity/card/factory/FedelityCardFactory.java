package com.supermarket.fedelity.card.factory;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.ErrorResource;
import com.supermarket.fedelity.card.dto.FedelityCardResource;
import com.supermarket.fedelity.card.entity.ErrorEntity;
import com.supermarket.fedelity.card.entity.FedelityCard;
import com.supermarket.fedelity.card.jpa.PuntoVenditaRepository;

@Component
public class FedelityCardFactory {

	@Lazy // per evitare la riconssione vistio che abbiamo un istanza di fedelitycardfactory in cleintefacotry
	@Autowired
	private ClienteFactory clienteFactory;
	
	@Autowired
	private PuntoVenditaRepository puntoVenditaRepository;

	public FedelityCardResource entityToResource(FedelityCard card) {

		FedelityCardResource resource = new FedelityCardResource();

		if (null == card) {
			resource.setError(new ErrorResource());
			resource.getError().setError("record not found 404");
			resource.getError().setDescription("no comment");
		} else if (null != card.getError()) { // se record in errore setto solo quest'ultimo
			if(!"".equalsIgnoreCase(card.getError().getError())) {
				resource.setError(new ErrorResource());
				resource.getError().setError(card.getError().getError());
				resource.getError().setDescription(card.getError().getDescription());
			}
		} else {

			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
				resource.setCliente(clienteFactory.entityToResource(card.getClienti()));
			}
			resource.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? card.getDataCreazioneTessera().toString() : null);
			resource.setPuntoVenditaNome(card.getPuntoVendita().get(0).getNomePuntoVendita());
			resource.setNumeroTessera(card.getNumeroTessera());
			resource.setPunti(card.getPunti());
		}

		return resource;
	}
	
	public FedelityCard resourceToEntity(FedelityCardResource card) {

		FedelityCard entity = new FedelityCard();
		
		if (null == card) {
			entity.setError(new ErrorEntity());
			entity.getError().setError("record not found 404");
			entity.getError().setDescription("no comment");
		} else if (null != card.getError()) {
				if(!"".equalsIgnoreCase(card.getError().getError())) { // se record in errore setto solo quest'ultimo
				entity.setError(new ErrorEntity());
				entity.getError().setError(card.getError().getError());
				entity.getError().setDescription(card.getError().getDescription());
				}
		} else {

//			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
//				resource.setCliente(card.getClienti().get(0).clienteToResource(card.getClienti()));
//			}
			entity.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? OffsetDateTime.parse(card.getDataCreazioneTessera()) : null);
//			entity.setPuntoVendita(card.getPuntoVendita().get(0).getNomePuntoVendita()); // TODO
			entity.setNumeroTessera(card.getNumeroTessera());
			entity.setPunti(card.getPunti());
		}

		return entity;
	}
	
}

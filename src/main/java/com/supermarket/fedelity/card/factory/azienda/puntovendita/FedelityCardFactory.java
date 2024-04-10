package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.cliente.ClienteFactory;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;

@Component
public class FedelityCardFactory {

	@Lazy // per evitare la riconssione vistio che abbiamo un istanza di fedelitycardfactory in clientefacotry
	@Autowired
	private ClienteFactory clienteFactory;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaRepository;
	
	public FedelityCardRequest entityToRequest(FedelityCard card) throws Exception { // TODO to response not request

		FedelityCardRequest request = new FedelityCardRequest();

		if (null == card) {
			throw new Exception();
		} else {

//			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
//				request.setCliente(clienteFactory.entityToRequest(card.getClienti()));
//			}
			request.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? card.getDataCreazioneTessera().toString() : null);
//			System.out.println("ciao : " + CollectionUtils.isEmpty(card.getPuntiVendita()));
//			if(!CollectionUtils.isEmpty(card.getPuntiVendita()))
//				request.setPuntoVenditaNome(card.getPuntiVendita().get(0).getNomePuntoVendita());
			request.setNumeroTessera(card.getNumeroTessera());
			request.setPunti(card.getPunti());
		}

		return request;
	}
	
	public FedelityCard requestToEntity(FedelityCardRequest card, PuntoVendita puntoVendita) {

		FedelityCard entity = new FedelityCard();
		
		if (null != card) {

//			if (!CollectionUtils.isEmpty(card.getClienti())) { // TODO
//				entity.setClienti(clienteFactory.requestToEntity(card.getClienti()));
//			}
			entity.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? OffsetDateTime.parse(card.getDataCreazioneTessera()) : null);
			entity.setPuntoVendita(puntoVendita); // TODO
			entity.setNumeroTessera(card.getNumeroTessera());
			entity.setPunti(card.getPunti());
			entity.setDataCreazioneTessera(OffsetDateTime.now());
			entity.setPuntoVendita(puntoVendita);
			
		}

		return entity;
	}
	
	public List<FedelityCard> requestToEntity(List<FedelityCardRequest> listCard, PuntoVendita puntoVendita) {

		List<FedelityCard> listEntity = new ArrayList<FedelityCard>();
		
		for(FedelityCardRequest card : listCard) {
			listEntity.add(requestToEntity(card, puntoVendita));
		}

		return listEntity;
	}
	
}

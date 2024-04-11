package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.cliente.ClienteFactory;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.utility.Utility;

@Component
public class FedelityCardFactory {

	@Lazy // per evitare la riconssione vistio che abbiamo un istanza di fedelitycardfactory in clientefacotry
	@Autowired
	private ClienteFactory clienteFactory;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardJpaRepository;
	
	public FedelityCardRequest entityToRequest(FedelityCard card) throws Exception { // TODO to response not request

		FedelityCardRequest request = new FedelityCardRequest();

		if (null == card) {
			throw new Exception();
		} else {

//			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
//				request.setCliente(clienteFactory.entityToRequest(card.getClienti()));
//			}
//			request.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? card.getDataCreazioneTessera().toString() : null);
//			System.out.println("ciao : " + CollectionUtils.isEmpty(card.getPuntiVendita()));
//			if(!CollectionUtils.isEmpty(card.getPuntiVendita()))
//				request.setPuntoVenditaNome(card.getPuntiVendita().get(0).getNomePuntoVendita());
			request.setNumeroTessera(card.getNumeroTessera());
			request.setPunti(card.getPunti());
		}

		return request;
	}
	
	public FedelityCard requestToEntity(FedelityCardRequest resource, PuntoVendita puntoVendita) {

		FedelityCard entity = new FedelityCard();
		
		String idIdentifier = null;
		
		if (null != resource) {
			
			if(StringUtils.isEmpty(resource.getNumeroTessera()) || resource.getNumeroTessera().length() < 20) {
				
				idIdentifier = Utility.generateRandomString(); // generate unique idIdentifier for fedelitycard
				while(fedelityCardJpaRepository.getAllIdIdentifier().contains(idIdentifier)) {  // TODO test if generate id exist on db re-generate it
					idIdentifier = Utility.generateRandomString();
				}
//				entity.setDataCreazioneTessera(OffsetDateTime.now()); // OffsetDateTime.parse(resource.getDataCreazioneTessera(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				entity.setPuntoVendita(puntoVendita); // TODO
				entity.setNumeroTessera(idIdentifier);
				entity.setPunti(resource.getPunti());
			} else {
				entity = fedelityCardJpaRepository.findByNumeroTessera(resource.getNumeroTessera());
			}
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

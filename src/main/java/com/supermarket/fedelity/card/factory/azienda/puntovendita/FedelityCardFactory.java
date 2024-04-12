package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.utility.Utility;

@Component
public class FedelityCardFactory {

//	@Lazy // per evitare la riconssione vistio che abbiamo un istanza di fedelitycardfactory in clientefacotry
//	@Autowired
//	private ClienteFactory clienteFactory;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardJpaRepository;
	
	public FedelityCardRequest entityToResource(FedelityCard entity) { // TODO to response not request

		FedelityCardRequest request = new FedelityCardRequest();

		if (null != entity) {

//			if (null != card.getClienti() || !card.getClienti().isEmpty()) {
//				request.setCliente(clienteFactory.entityToRequest(card.getClienti()));
//			}
//			request.setDataCreazioneTessera(null != card.getDataCreazioneTessera() ? card.getDataCreazioneTessera().toString() : null);
//			System.out.println("ciao : " + CollectionUtils.isEmpty(card.getPuntiVendita()));
//			if(!CollectionUtils.isEmpty(card.getPuntiVendita()))
//				request.setPuntoVenditaNome(card.getPuntiVendita().get(0).getNomePuntoVendita());
			request.setNumeroTessera(entity.getNumeroTessera());
			request.setPunti(entity.getPunti());
		}

		return request;
	}
	
	public List<FedelityCardRequest> entityToResource(List<FedelityCard> listEntity){
	
		List<FedelityCardRequest> listResponse = new ArrayList<FedelityCardRequest>();
		
		for(FedelityCard fc : listEntity) {
			listResponse.add(entityToResource(fc));
		}
		
		return listResponse;
		
	}
	
	public FedelityCard requestToEntity(FedelityCardRequest resource, PuntoVendita puntoVendita) {

		FedelityCard entity = new FedelityCard();
		
		String idIdentifier = null;
		
		List<String> listId = fedelityCardJpaRepository.getAllIdIdentifier();
		
		if (null != resource) {
			
			if(StringUtils.isEmpty(resource.getNumeroTessera()) || resource.getNumeroTessera().length() < 20) {
				
				idIdentifier = Utility.generateRandomString(); // generate unique idIdentifier for fedelitycard
				while(listId.contains(idIdentifier)) {  // TODO test if generate id exist on db re-generate it
					idIdentifier = Utility.generateRandomString();
				}
//				entity.setDataCreazioneTessera(OffsetDateTime.now()); // OffsetDateTime.parse(resource.getDataCreazioneTessera(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				entity.setPuntoVendita(puntoVendita); // TODO
				entity.setNumeroTessera(idIdentifier);
				entity.setPunti(resource.getPunti());
			} else {
				entity = fedelityCardJpaRepository.findByNumeroTessera(resource.getNumeroTessera());
//				entity.setPuntoVendita(puntoVendita); // TODO
				entity.setPunti(resource.getPunti());
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

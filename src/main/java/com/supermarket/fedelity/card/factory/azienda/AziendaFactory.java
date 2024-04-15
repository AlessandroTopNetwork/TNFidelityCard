package com.supermarket.fedelity.card.factory.azienda;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.entity.cliente.Cliente;
import com.supermarket.fedelity.card.factory.BaseFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.FedelityCardFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;
import com.supermarket.fedelity.card.jpa.azienda.AziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.utility.Utility;

@Component
public class AziendaFactory extends BaseFactory {

//	@Autowired
//	private PuntoVenditaFactory puntoVenditaFactory;

//	@Autowired
//	private FedelityCardFactory fedelityCardFactory;

	@Autowired
	private AziendaJPARepository aziendaJpaRepository;

//	@Autowired
//	private PuntoVenditaJPARepository puntoVenditaJpaRepository;
//
//	@Autowired
//	private FedelityCardJPARepository fedelityCardJpaRepository;

	public AziendaRequest entityToResource(Azienda entity) {

		AziendaRequest resource = new AziendaRequest();

		if (null != entity) {
			resource.setCitta(entity.getCitta());
			resource.setNomeAzienda(entity.getNomeAzienda());
			resource.setRegione(entity.getRegione());
			resource.setIdIdentifier(entity.getIdIdentifier());
		}

		return resource;
	}

	public List<AziendaRequest> entityToResource(List<Azienda> entityList) {

		List<AziendaRequest> aziendeRequest = new ArrayList<AziendaRequest>(); // obj main response


		for (Azienda resource : entityList) {
			aziendeRequest.add(entityToResource(resource)); // ad many Azienda obj found on db
		}

		return aziendeRequest;

	}

	// resource to entity

	public Azienda resourceToEntity(AziendaRequest resource) {

		Azienda entity = new Azienda();
		
		String idIdentifier = null;
		
		List<String> listIdIdentifier = aziendaJpaRepository.getAllIdIdentifier();

		if (null != resource) { // check null safe
			if(StringUtils.isEmpty(resource.getIdIdentifier()) || resource.getIdIdentifier().length() < 20) { // if seend id null then create new azienda 
				
				idIdentifier = Utility.generateRandomString(); // generate unique idIdentifier for azienda
				while(listIdIdentifier.contains(idIdentifier)) {  // TODO test if generate id exist on db re-generate it
					idIdentifier = Utility.generateRandomString();
				}
				entity.setCitta(resource.getCitta());
				entity.setNomeAzienda(resource.getNomeAzienda());
				entity.setRegione(resource.getRegione());
				entity.setIdIdentifier(idIdentifier);
			} else { // otherwise search azienda on db
				entity = aziendaJpaRepository.findByIdIdentifier(resource.getIdIdentifier());
				// test case update
				entity.setCitta(resource.getCitta());
				entity.setNomeAzienda(resource.getNomeAzienda());
				entity.setRegione(resource.getRegione());
			}
		} else {
			log.error(error(getClass().getCanonicalName()));
		}

		return entity;
	}

//	public CreazioneAziendaRequest resourceToEntity(CreazioneAziendaRequest resource) { // TODO
//
//		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();
//
//		for (AziendaRequest ar : resource.getAzienda()) {
//			Azienda azienda = aziendaJpaRepository.save(resourceToEntity(ar)); // convert and save azienda
//			
//			listPuntiVendita = puntoVenditaJpaRepository.saveAll(puntoVenditaFactory.resourceToEntity(ar.getPuntiVendita(), azienda)); // convert puntivendita associced and save
//			
//			azienda.setPuntiVendita(listPuntiVendita); // set list punti vendita 
//			
//			aziendaJpaRepository.save(azienda); // up azienda
//		}
//
//		return resource;
//	}

}

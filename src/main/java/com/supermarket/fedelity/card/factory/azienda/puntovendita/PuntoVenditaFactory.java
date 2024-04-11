package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.BaseFactory;
import com.supermarket.fedelity.card.jpa.azienda.TipologiaAziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.utility.Utility;

@Component
public class PuntoVenditaFactory extends BaseFactory {
	
	@Autowired
	private FedelityCardFactory fedelityCardFactory;;
	
//	@Autowired
//	private 
	
	@Autowired
	private TipologiaAziendaJPARepository tipoAziendaJpaRepository;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;

	public PuntoVenditaRequest entityToResource(PuntoVendita entity) {
		
		PuntoVenditaRequest puntoVenditaRequest = new PuntoVenditaRequest();
		
		if(null != entity) {
			
		}
		
		return puntoVenditaRequest;
	}

	public List<PuntoVenditaRequest> entityToResource(List<PuntoVendita> entityList) {

		List<PuntoVenditaRequest> listPuntiVendita = new ArrayList<PuntoVenditaRequest>();

		for (PuntoVendita resource : entityList) {
			listPuntiVendita.add(entityToResource(resource));
		}

		return listPuntiVendita;

	}
	
	public PuntoVendita resourceToEntity(PuntoVenditaRequest resource, Azienda azienda) {

		PuntoVendita entity = new PuntoVendita();
		
		String idIdentifier = null;

		if(null != resource) {
			
			if(StringUtils.isEmpty(resource.getIdIdentifier()) || resource.getIdIdentifier().length() < 20) { // custom mocket lenght of all idIdentifier will be create a tab config for this
			
				idIdentifier = Utility.generateRandomString(); // generate unique idIdentifier for puntovendita
				while(puntoVenditaJpaRepository.getAllIdIdentifier().contains(idIdentifier)) {  // TODO test if generate id exist on db re-generate it
					idIdentifier = Utility.generateRandomString();
				}
				entity.setAzienda(azienda);
				entity.setCitta(resource.getCitta());
				entity.setIdIdentifier(idIdentifier); 
				entity.setNomePuntoVendita(resource.getNomePuntoVendita());
				entity.setRegione(resource.getRegione());
				TipologiaAzienda tipoAzienda = tipoAziendaJpaRepository.findByTipoAzienda(resource.getTipoAzienda().getTipoAzienda());
				entity.setTipoAzienda(tipoAzienda);
			
			} else {
				entity = puntoVenditaJpaRepository.findByIdIdentifier(resource.getIdIdentifier());
				// test case update
				entity.setAzienda(azienda);
				entity.setCitta(resource.getCitta());
//				entity.setIdIdentifier(idIdentifier); // not override this filed because this is try update record on db
				entity.setNomePuntoVendita(resource.getNomePuntoVendita());
				entity.setRegione(resource.getRegione());
				TipologiaAzienda tipoAzienda = tipoAziendaJpaRepository.findByTipoAzienda(resource.getTipoAzienda().getTipoAzienda());
				entity.setTipoAzienda(tipoAzienda);
			}
		}

		return entity;
	}

	public List<PuntoVendita> resourceToEntity(List<PuntoVenditaRequest> resourceList, Azienda azienda) {

		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (PuntoVenditaRequest resource : resourceList) {
			listPuntiVendita.add(resourceToEntity(resource, azienda));
		}

		return listPuntiVendita;
	}
	

	// exist record forse inutile
	
	public PuntoVendita resourceToEntityExsit(PuntoVenditaRequest resource) {

		PuntoVendita p = new PuntoVendita();

		if(null != resource) {
			if(null != resource.getIdIdentifier()) {
				p = puntoVenditaJpaRepository.findByIdIdentifier(resource.getIdIdentifier()); // TODO test
			}
		}

		return p;
	}

	public List<PuntoVendita> resourceToEntityExist(List<PuntoVenditaRequest> resourceList) {

		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (PuntoVenditaRequest resource : resourceList) {
			listPuntiVendita.add(resourceToEntityExsit(resource));
		}

		return listPuntiVendita;
	}

}

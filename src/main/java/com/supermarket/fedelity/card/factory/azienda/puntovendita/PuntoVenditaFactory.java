package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.util.ArrayList;
import java.util.List;

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
	
	
//	@Autowired
//	private AziendaFactory aziendaFactory;
	
	@Autowired
	private TipologiaAziendaJPARepository tipoAziendaJpaRepository;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;

	public PuntoVenditaRequest entityToResource(PuntoVendita entity) {

		return null;
	}

	public List<PuntoVenditaRequest> entityToresource(List<PuntoVendita> entityList) {

		List<PuntoVenditaRequest> listPuntiVendita = new ArrayList<PuntoVenditaRequest>();

		for (PuntoVendita resource : entityList) {
			listPuntiVendita.add(entityToResource(resource));
		}

		return listPuntiVendita;

	}
	
	public PuntoVendita resourceToEntity(PuntoVenditaRequest resource, Azienda azienda) {

		PuntoVendita p = new PuntoVendita();
		
		String idIdentifier = null;

		if(null != resource) {
			
			idIdentifier = Utility.generateRandomString(); // generate unique idIdentifier for puntovendita
			while(puntoVenditaJpaRepository.getAllIdIdentifier().contains(idIdentifier)) {  // TODO test if generate id exist on db re-generate it
				idIdentifier = Utility.generateRandomString();
			}
			p.setAzienda(azienda);
			p.setCitta(resource.getCitta());
			p.setIdIdentifier(idIdentifier); 
			p.setNomePuntoVendita(resource.getNomePuntoVendita());
			p.setRegione(resource.getRegione());
			TipologiaAzienda tipoAzienda = tipoAziendaJpaRepository.findByTipoAzienda(resource.getTipoAzienda().getTipoAzienda());
			p.setTipoAzienda(tipoAzienda);
			
		}

		return p;
	}

	public List<PuntoVendita> resourceToEntity(List<PuntoVenditaRequest> resourceList, Azienda azienda) {

		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (PuntoVenditaRequest resource : resourceList) {
			listPuntiVendita.add(resourceToEntity(resource, azienda));
		}

		return listPuntiVendita;
	}
	

	// exist record
	
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

package com.supermarket.fedelity.card.factory.azienda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;

@Component
public class AziendaFactory {

	
	public CreazioneAziendaRequest entityToRequest(Azienda entity) {
		
		return null;
	}

	
	public List<CreazioneAziendaRequest> entityToRequest(List<Azienda> entityList) {
		
		return null;
	}

	
	public Azienda requestToEntity(CreazioneAziendaRequest resource) {
		
		Azienda azienda = new Azienda();
		
		if(null != resource) {
			if(null != resource.getAzienda()) {
				
			}
		}
		
		return null;
	}

	
	public List<Azienda> requestToEntity(List<CreazioneAziendaRequest> resourceList) {
		
		List<Azienda> listAzienda = new ArrayList<Azienda>();
		
		for(CreazioneAziendaRequest resource : resourceList) {
			listAzienda.add(requestToEntity(resource));
		}
		
		return listAzienda;
	}

}

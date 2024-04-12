package com.supermarket.fedelity.card.factory.azienda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.TipologiaAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;
import com.supermarket.fedelity.card.factory.BaseFactory;

@Component
public class TipologiaAziendaFactory extends BaseFactory {

//	@Autowired
//	private 

	// entity to resource
	
	public TipologiaAziendaRequest entityToResource(TipologiaAzienda entity) {
		
		TipologiaAziendaRequest tipoAziendaRequest = new TipologiaAziendaRequest();
		
		if(null != entity) {
			tipoAziendaRequest.setTipoAzienda(entity.getTipoAzienda());
			tipoAziendaRequest.setDescrizione(entity.getDescrizione());
		}
		
		return tipoAziendaRequest;
	}

	public List<TipologiaAziendaRequest> entityToResource(List<TipologiaAzienda> listEntity) {
		
		List<TipologiaAziendaRequest> listResponse = new ArrayList<TipologiaAziendaRequest>();
		
		for (TipologiaAzienda ta : listEntity) {
			listResponse.add(entityToResource(ta));
		}
		
		return listResponse;
	}
	
	// resource to entity
	
	public TipologiaAzienda resourceToEntity(TipologiaAziendaRequest resource) {
		
		TipologiaAzienda tipoAzienda = new TipologiaAzienda();
		
		if(null != resource) {
			tipoAzienda.setTipoAzienda(resource.getTipoAzienda());
			tipoAzienda.setDescrizione(resource.getDescrizione());
		}
		
		return tipoAzienda;
	}

	public List<TipologiaAzienda> resourceToEntity(List<TipologiaAziendaRequest> listResource) {
		
		List<TipologiaAzienda> listResponse = new ArrayList<TipologiaAzienda>();
		
		for (TipologiaAziendaRequest tar : listResource) {
			listResponse.add(resourceToEntity(tar));
		}
		
		return listResponse;
	}

}

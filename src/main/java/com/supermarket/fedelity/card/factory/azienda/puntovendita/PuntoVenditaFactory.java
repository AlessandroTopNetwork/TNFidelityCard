package com.supermarket.fedelity.card.factory.azienda.puntovendita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.BaseFactory;
import com.supermarket.fedelity.card.factory.azienda.AziendaFactory;
import com.supermarket.fedelity.card.jpa.azienda.TipologiaAziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;

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

	public PuntoVendita resourceToEntity(PuntoVenditaRequest resource) {

		PuntoVendita p = new PuntoVendita();

		if(null != resource) {
			if(null != resource.getIdIdentifier()) {
				p = puntoVenditaJpaRepository.findByIdIdentifier(resource.getIdIdentifier()); // TODO test
			}
		}

		return p;
	}

	public List<PuntoVendita> resourceToEntity(List<PuntoVenditaRequest> resourceList) {

		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (PuntoVenditaRequest resource : resourceList) {
			listPuntiVendita.add(resourceToEntity(resource));
		}

		return listPuntiVendita;
	}

}

package com.supermarket.fedelity.card.factory.azienda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.factory.BaseFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;

@Component
public class AziendaFactory extends BaseFactory {

	@Autowired
	private PuntoVenditaFactory puntoVenditaFactory;

	public CreazioneAziendaRequest entityToResource(Azienda entity) {

		return null;
	}

	public List<CreazioneAziendaRequest> entityToresource(List<Azienda> entityList) {

		List<CreazioneAziendaRequest> listAzienda = new ArrayList<CreazioneAziendaRequest>();

		for (Azienda resource : entityList) {
			listAzienda.add(entityToResource(resource));
		}

		return listAzienda;

	}

	public Azienda resourceToEntity(CreazioneAziendaRequest resource) {

		Azienda azienda = new Azienda();

		if (null != resource) { // check null safe
			if (null != resource.getAzienda()) {
				if (null != resource.getAzienda().getPuntiVendita()) {
					AziendaRequest aziendaRequest = resource.getAzienda();
					azienda.setCitta(aziendaRequest.getCitta());
					azienda.setNomeAzienda(aziendaRequest.getNomeAzienda());
					azienda.setPuntiVendita(puntoVenditaFactory.resourceToEntity(aziendaRequest.getPuntiVendita(), azienda));
					azienda.setRegione(aziendaRequest.getRegione());
				} else {
					log.error(error(getClass().getCanonicalName()));
				}
			} else {
				log.error(error(getClass().getCanonicalName()));
			}
		} else {
			log.error(error(getClass().getCanonicalName()));
		}

		return azienda;
	}

	public List<Azienda> resourceToEntity(List<CreazioneAziendaRequest> resourceList) {

		List<Azienda> listAzienda = new ArrayList<Azienda>();

		for (CreazioneAziendaRequest resource : resourceList) {
			listAzienda.add(resourceToEntity(resource));
		}

		return listAzienda;
	}

}

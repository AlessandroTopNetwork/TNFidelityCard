package com.supermarket.fedelity.card.service;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

public interface ServicePuntoVendita {
	
	List<PuntoVenditaRequest> getPuntiVendita(String idAzienda); // or obj Azienda
	
	PuntoVenditaRequest findByIdIdentifier(String idIdentifier);
	
//	PuntoVenditaRequest createPuntoVendita(PuntoVenditaRequest azienda); // TODO forse inutile
	
	List<PuntoVenditaRequest> saveAll(List<PuntoVendita> listPuntoVendita);

	CreazioneAziendaRequest updatePuntiVendita(CreazioneAziendaRequest aziendaResource) throws Exception;

}

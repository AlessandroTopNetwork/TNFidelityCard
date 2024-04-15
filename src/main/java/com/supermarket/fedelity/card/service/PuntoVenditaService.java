package com.supermarket.fedelity.card.service;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

public interface PuntoVenditaService {
	
	AziendaRequest getPuntiVendita(String idIdentifierAzienda); // or obj Azienda
	
	AziendaRequest findByIdIdentifier(String idIdentifierPuntoVendita);
	
	AziendaRequest createPuntiVendita(AziendaRequest aziendaResource) throws Exception; // TODO forse inutile
	
	List<PuntoVenditaRequest> saveAll(List<PuntoVendita> listPuntoVendita);

	AziendaRequest updatePuntiVendita(AziendaRequest aziendaResource) throws Exception;
	
	String deletePuntoVendita(String idIdentifier);

}

package com.supermarket.fedelity.card.service;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;

public interface ServiceAzienda { // TODO da fare service impl
	
	CreazioneAziendaRequest getAziende();
	
	AziendaRequest findByIdIdentifier(String idIdentifier);
	
	CreazioneAziendaRequest createAziendaAndRetailOutlet(CreazioneAziendaRequest aziendaResource);
	
	CreazioneAziendaRequest updateAzienda(CreazioneAziendaRequest aziendaResource);
	
}

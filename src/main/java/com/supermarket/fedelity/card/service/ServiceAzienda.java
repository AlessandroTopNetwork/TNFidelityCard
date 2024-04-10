package com.supermarket.fedelity.card.service;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;

public interface ServiceAzienda { // TODO da fare service impl
	
	CreazioneAziendaRequest getAziende();
	
	CreazioneAziendaRequest findById(long id);
	
	CreazioneAziendaRequest createAziendaAndRetailOutlet(CreazioneAziendaRequest azienda);
	
}

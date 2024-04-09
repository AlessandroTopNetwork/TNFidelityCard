package com.supermarket.fedelity.card.serviceinterface;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;

public interface ServiceAzienda { // TODO da fare service impl
	
	List<CreazioneAziendaRequest> getAziende();
	
	CreazioneAziendaRequest findById(long id);
	
	CreazioneAziendaRequest createAzienda(CreazioneAziendaRequest azienda);
	
}

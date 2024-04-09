package com.supermarket.fedelity.card.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.factory.azienda.AziendaFactory;
import com.supermarket.fedelity.card.jpa.azienda.AziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.TipologiaAziendaJPARepository;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.ServiceAzienda;

@Service
public class ServiceAziendaImpl extends BaseService implements ServiceAzienda{
	
	@Autowired
	private AziendaFactory aziendaFactory;
	
	@Autowired
	private AziendaJPARepository aziendaJpaRepository;
	
	@Autowired
	private TipologiaAziendaJPARepository tipologiaAziendaJpaRepository;

	@Override
	public List<CreazioneAziendaRequest> getAziende() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreazioneAziendaRequest findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreazioneAziendaRequest createAzienda(CreazioneAziendaRequest aziendaResource) {
		log.info("call createAzienda");
		Azienda azienda = aziendaFactory.resourceToEntity(aziendaResource); // convert request from end point to entity
//		fedelityCardRepository.save(azienda.getCartaFedelta());
		aziendaJpaRepository.save(azienda);
		log.info("end createAzienda");
		return aziendaResource;
	}

}

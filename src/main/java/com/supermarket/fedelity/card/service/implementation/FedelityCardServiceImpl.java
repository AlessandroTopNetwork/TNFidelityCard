package com.supermarket.fedelity.card.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.FedelityCardFactory;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.FedelityCardService;

@Service
public class FedelityCardServiceImpl extends BaseService implements FedelityCardService {

	@Autowired
	private FedelityCardFactory fedelityCardFactory;

	@Autowired
	private FedelityCardJPARepository fedelityCardJpaRepository;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;

	@Override
	public List<FedelityCardRequest> getAllFedelityCardByPuntoVendita(String idIdentifierPuntoVendita) {
		
		List<FedelityCardRequest> listResponse = new ArrayList<FedelityCardRequest>();
		
		PuntoVendita pv = puntoVenditaJpaRepository.findByIdIdentifier(idIdentifierPuntoVendita);
		
		List<FedelityCard> listFedelityCard = pv.getCarteFedelta();
		
		listResponse = fedelityCardFactory.entityToResource(listFedelityCard);
		
		return listResponse;
	}

	@Override
	public FedelityCardRequest findByNumeroTessera(String numeroTessera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FedelityCardRequest createFedelityCard(FedelityCardRequest aziendaResource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FedelityCardRequest updateFedelityCard(FedelityCardRequest aziendaResource) {
		// TODO Auto-generated method stub
		return null;
	}

}

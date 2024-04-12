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
		
		PuntoVendita pv = puntoVenditaJpaRepository.findByIdIdentifier(idIdentifierPuntoVendita); // find punto vendita 
		
		listResponse = fedelityCardFactory.entityToResource(pv.getCarteFedelta()); // convert fedelity card of punto vendita
		
		return listResponse;
	}

	@Override
	public FedelityCardRequest findByNumeroTessera(String numeroTessera) {
		return fedelityCardFactory.entityToResource(fedelityCardJpaRepository.findByNumeroTessera(numeroTessera)); // find fedelity card and convert it
	}

	@Override
	public FedelityCardRequest createFedelityCard(FedelityCardRequest fedelityCardResource, String idIdentifierPuntoVendita) {
		
		PuntoVendita pv = puntoVenditaJpaRepository.findByIdIdentifier(idIdentifierPuntoVendita);

		FedelityCard entity = fedelityCardFactory.requestToEntity(fedelityCardResource, pv);
		
		fedelityCardJpaRepository.save(entity);
		
		return fedelityCardResource;
	}

	@Override
	public FedelityCardRequest updateFedelityCard(FedelityCardRequest fedelityCardResource) {
		
		FedelityCard entity = fedelityCardFactory.requestToEntity(fedelityCardResource, null);
		
		fedelityCardJpaRepository.save(entity);
		
		return fedelityCardResource;
	}

	@Override
	public void deleteFedelityCard(String numeroTessera) {
		FedelityCard fc = fedelityCardJpaRepository.findByNumeroTessera(numeroTessera);
		
		fedelityCardJpaRepository.delete(fc); //fedelityCardJpaRepository.delete(fedelityCardJpaRepository.findByNumeroTessera(numeroTessera));
	}

}

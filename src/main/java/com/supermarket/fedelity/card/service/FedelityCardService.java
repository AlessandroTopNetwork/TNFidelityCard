package com.supermarket.fedelity.card.service;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;

public interface FedelityCardService {
	
	List<FedelityCardRequest> getAllFedelityCardByPuntoVendita(String idIdentifierPuntoVendita);
	
	FedelityCardRequest findByNumeroTessera(String numeroTessera); // idIdentifier
	
	FedelityCardRequest createFedelityCard(FedelityCardRequest fedelityCardResource, String idIdentifierPuntoVendita);
	
	FedelityCardRequest updateFedelityCard(FedelityCardRequest fedelityCardResource);
	
	String deleteFedelityCard(String numeroTessera);

}

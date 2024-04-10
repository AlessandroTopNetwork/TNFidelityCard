package com.supermarket.fedelity.card.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.ServicePuntoVendita;

@Service
public class ServicePuntoVednitaImpl extends BaseService implements ServicePuntoVendita {
	
	@Autowired
	private PuntoVenditaFactory puntoVenditaFactory;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;

	@Override
	public List<PuntoVenditaRequest> getPuntiVendita(String idAzienda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuntoVenditaRequest findByIdIdentifier(String idIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PuntoVenditaRequest> saveAll(List<PuntoVendita> listPuntoVendita) {
		puntoVenditaJpaRepository.saveAll(listPuntoVendita);
		return puntoVenditaFactory.entityToResource(listPuntoVendita);
	}

}

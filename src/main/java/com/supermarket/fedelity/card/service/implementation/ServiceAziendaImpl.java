package com.supermarket.fedelity.card.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.azienda.AziendaFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.FedelityCardFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;
import com.supermarket.fedelity.card.jpa.azienda.AziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.TipologiaAziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.ServiceAzienda;
import com.supermarket.fedelity.card.service.ServicePuntoVendita;

@Service
public class ServiceAziendaImpl extends BaseService implements ServiceAzienda{
	
	@Autowired
	private AziendaFactory aziendaFactory;
	
	@Autowired
	private PuntoVenditaFactory puntoVenditaFactory;
	
	@Autowired
	private FedelityCardFactory fedelityCardFactory;
	
	@Autowired
	private AziendaJPARepository aziendaJpaRepository;
	
	@Autowired
	private TipologiaAziendaJPARepository tipologiaAziendaJpaRepository;
	
	@Autowired
	private ServicePuntoVendita servicePuntoVendita;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardJPARepository;

	@Override
	public CreazioneAziendaRequest getAziende() {
		
		CreazioneAziendaRequest response = new CreazioneAziendaRequest();
		
		response.setAzienda(aziendaFactory.entityToResource(aziendaJpaRepository.findAll())); // find All Aziende and convert it in resource
		
		return response;
	}

	@Override
	public AziendaRequest findByIdIdentifier(String idIdentifier) {
		
		AziendaRequest response = new AziendaRequest();
		
		Azienda azienda = aziendaJpaRepository.findByIdIdentifier(idIdentifier);
		
		response = aziendaFactory.entityToResource(azienda);
		
//		List<PuntoVendita> puntiVendita = puntoVenditaJpaRepository.findByAzienda(azienda.getIdIdentifier())); // to TEst
		
		response.setPuntiVendita(puntoVenditaFactory.entityToResource(azienda.getPuntiVendita()));
		
		for(int i = 0 ; i < response.getPuntiVendita().size(); i++ ) { // for on punti vendita
			
//			FedelityCardRequest fcr = new FedelityCardRequest();
			
			response.getPuntiVendita().get(i) // get current list punti vendita
					.setListFedelityCard( // set list into main obj response
							fedelityCardFactory.entityToResource( // convert list fedelity card to resource
									findMatchingPuntoVedinta(
											response.getPuntiVendita().get(i), azienda.getPuntiVendita()) // search for the specific point of sale entity, since it is not certain that the id of the dto list is the same as that of the list entity
										.getCarteFedelta() // and list of fedelityCard
									)
							);
			
		}
		
		return response;
	}

	@Override
	public CreazioneAziendaRequest createAziendaAndRetailOutlet(CreazioneAziendaRequest aziendaResource) {
		log.info("call createAzienda");
		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (AziendaRequest ar : aziendaResource.getAzienda()) {
			Azienda azienda = aziendaJpaRepository.save(aziendaFactory.resourceToEntity(ar)); // convert and save azienda
			
			listPuntiVendita = puntoVenditaJpaRepository.saveAll(puntoVenditaFactory.resourceToEntity(ar.getPuntiVendita(), azienda)); // convert puntivendita associced and save
			
			azienda.setPuntiVendita(listPuntiVendita); // set list punti vendita
			
			aziendaJpaRepository.save(azienda); // up azienda
		}

		log.info("end createAzienda");
		return aziendaResource;
	}

	@Override
	public CreazioneAziendaRequest updateAzienda(CreazioneAziendaRequest aziendaResource) {
		log.info("call updateAzienda");

		for (AziendaRequest ar : aziendaResource.getAzienda()) {
			Azienda azienda = aziendaJpaRepository.save(aziendaFactory.resourceToEntity(ar)); // convert and save azienda			
		}

		log.info("end updateAzienda");
		return aziendaResource;
	}
	
//	private PuntoVendita findMatchingObject(List<PuntoVenditaRequest> listDto, List<PuntoVendita> listEntity) { // TODO test
//	    return listDto.stream()
//	            .flatMap(dto -> listEntity.stream()
//	                    .filter(entity -> // !dto.equals(entity) &&
//	                            Objects.equals(dto.getIdIdentifier(), entity.getIdIdentifier())))
//	            .findFirst()
//	            .orElse(null);
//	}
//
	private PuntoVendita findMatchingPuntoVedinta(PuntoVenditaRequest dto, List<PuntoVendita> listEntity) { // TODO test
		return listEntity.stream()
					.filter(entity -> // !dto.equals(entity) &&
						Objects.equals(dto.getIdIdentifier(), entity.getIdIdentifier()))
					.findFirst()
					.orElse(null);
	}

}

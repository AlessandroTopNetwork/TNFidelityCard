package com.supermarket.fedelity.card.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.azienda.AziendaFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.FedelityCardFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;
import com.supermarket.fedelity.card.jpa.azienda.AziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.TipologiaAziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.FedelityCardJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.service.AziendaService;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.PuntoVenditaService;
import com.supermarket.fedelity.card.utility.Utility;

@Service
public class AziendaServiceImpl extends BaseService implements AziendaService{
	
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
	private PuntoVenditaService servicePuntoVendita;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;
	
	@Autowired
	private FedelityCardJPARepository fedelityCardJPARepository;

	@Override
	public CreazioneAziendaRequest getAziende() {
		
		CreazioneAziendaRequest response = new CreazioneAziendaRequest();
		
		List<Azienda> listAzienda = aziendaJpaRepository.findAll();
		
		response.setAziende(aziendaFactory.entityToResource(listAzienda)); // find All Aziende and convert it in resource
		
		for(int i = 0; i < listAzienda.size(); i++) {
			
			AziendaRequest aziendaResponse = response.getAziende().get(i);
			
			Azienda azienda = listAzienda.get(i);
			
			aziendaResponse.setPuntiVendita(puntoVenditaFactory.entityToResource(azienda.getPuntiVendita()));
			
			setFedelityCardToPuntoVendita(aziendaResponse, azienda);
			
//			for(int a = 0 ; a < aziendaResponse.getPuntiVendita().size(); a++ ) { // for on punti vendita
//				
//				aziendaResponse.getPuntiVendita().get(a) // get current punto vendita
//						.setListFedelityCard( // set list into main obj response
//								fedelityCardFactory.entityToResource( // convert list fedelity card to resource
//										findMatchingPuntoVedinta(
//												aziendaResponse.getPuntiVendita().get(a), azienda.getPuntiVendita() // search for the specific point of sale entity, since it is not certain that the id of the dto list is the same as that of the list entity
//											).getCarteFedelta() // and list of fedelityCard
//										)
//								);
//				
//			}
			
		}
		
		return response;
	}

	@Override
	public AziendaRequest findByIdIdentifier(String idIdentifier) throws Exception {
		
		AziendaRequest response = new AziendaRequest();
		
		Azienda azienda = aziendaJpaRepository.findByIdIdentifier(idIdentifier);
		
		if(null != azienda) {
			response = aziendaFactory.entityToResource(azienda);


//			List<PuntoVendita> puntiVendita = puntoVenditaJpaRepository.findByAzienda(azienda.getIdIdentifier())); // to TEst

			response.setPuntiVendita(puntoVenditaFactory.entityToResource(azienda.getPuntiVendita()));

			setFedelityCardToPuntoVendita(response, azienda);
		} else {
			throw new Exception("Azienda not found for id : " + idIdentifier);
		}
		
		return response;
	}

	@Override
	public CreazioneAziendaRequest createAziendaAndRetailOutlet(CreazioneAziendaRequest aziendaResource) {
		log.info("call createAzienda");
		List<PuntoVendita> listPuntiVendita = new ArrayList<PuntoVendita>();

		for (int i = 0; i < aziendaResource.getAziende().size(); i++) {
			Azienda azienda = aziendaJpaRepository.save(aziendaFactory.resourceToEntity(aziendaResource.getAziende().get(i))); // convert and save azienda
			
			listPuntiVendita = puntoVenditaJpaRepository.saveAll(puntoVenditaFactory.resourceToEntity(aziendaResource.getAziende().get(i).getPuntiVendita(), azienda)); // convert puntivendita associced and save
			
			azienda.setPuntiVendita(listPuntiVendita); // set list punti vendita
			
			aziendaResource.getAziende().get(i).setIdIdentifier(azienda.getIdIdentifier());
			
			aziendaJpaRepository.save(azienda); // up azienda
		}
		
		log.info("end createAzienda");
		return aziendaResource;
	}

	@Override
	public CreazioneAziendaRequest updateAzienda(CreazioneAziendaRequest aziendaResource) {
		log.info("call updateAzienda");

		for (AziendaRequest ar : aziendaResource.getAziende()) {
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

	@Override
	public String deleteAzienda(String idIdentifier) {
		Azienda a = aziendaJpaRepository.findByIdIdentifier(idIdentifier);
		
		aziendaJpaRepository.delete(a);
		
		return "remove azienda with id : " + idIdentifier;
	}
	
	private void setFedelityCardToPuntoVendita(AziendaRequest response, Azienda azienda) {
		for(int i = 0 ; i < response.getPuntiVendita().size(); i++ ) { // for on punti vendita
						
			response.getPuntiVendita().get(i) // get current list punti vendita
					.setListFedelityCard( // set list into main obj response
							fedelityCardFactory.entityToResource( // convert list fedelity card to resource
									Utility.findMatchingPuntoVedinta(
											response.getPuntiVendita().get(i), azienda.getPuntiVendita() // search for the specific point of sale entity, since it is not certain that the id of the dto list is the same as that of the list entity
										).getCarteFedelta() // and list of fedelityCard
									)
							);
			
		}
	}
	


}

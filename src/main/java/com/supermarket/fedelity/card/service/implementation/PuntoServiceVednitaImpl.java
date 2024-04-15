package com.supermarket.fedelity.card.service.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.FedelityCardFactory;
import com.supermarket.fedelity.card.factory.azienda.puntovendita.PuntoVenditaFactory;
import com.supermarket.fedelity.card.jpa.azienda.AziendaJPARepository;
import com.supermarket.fedelity.card.jpa.azienda.puntovendita.PuntoVenditaJPARepository;
import com.supermarket.fedelity.card.service.BaseService;
import com.supermarket.fedelity.card.service.PuntoVenditaService;
import com.supermarket.fedelity.card.utility.Utility;

@Service
public class PuntoServiceVednitaImpl extends BaseService implements PuntoVenditaService {
	
	@Autowired
	private PuntoVenditaFactory puntoVenditaFactory;
	
	@Autowired
	private FedelityCardFactory fedelityCardFactory;
	
	@Autowired
	private PuntoVenditaJPARepository puntoVenditaJpaRepository;
	
	@Autowired
	private AziendaJPARepository aziendaJpaRepository;

	@Override
	public AziendaRequest getPuntiVendita(String idIdentifierAzienda) { // get punti vendita from id azienda
		
		AziendaRequest response = null;
		
		Azienda a = aziendaJpaRepository.findByIdIdentifier(idIdentifierAzienda);
		
		if(!CollectionUtils.isEmpty(a.getPuntiVendita())) {
			response = setResponse(a.getPuntiVendita());
			
		}
		
		return response;
	}

	@Override
	public AziendaRequest findByIdIdentifier(String idIdentifierPuntoVendita) { // get one punto vendita by it id 
		
		AziendaRequest response = null;
		
		PuntoVendita puntoVendita = puntoVenditaJpaRepository.findByIdIdentifier(idIdentifierPuntoVendita);
		
		if(null != puntoVendita) {
			response = setResponse(Arrays.asList(puntoVendita));
		}
		
		return response;
	}
	
	@Override
	public AziendaRequest createPuntiVendita(AziendaRequest aziendaResource) throws Exception {
				
		Azienda a = null;
		PuntoVendita pv = null;
		
		boolean search = true;
		
		if(!CollectionUtils.isEmpty(aziendaResource.getPuntiVendita())) {
			for(PuntoVenditaRequest pvr : aziendaResource.getPuntiVendita()) {
				if(search) {
					search = false;
					a = aziendaJpaRepository.findByIdIdentifier(aziendaResource.getIdIdentifier());
					if(null == a) {
						throw new Exception("idIdentifier azienda not found, for id : " + aziendaResource.getIdIdentifier());
					}
				}
				pv = puntoVenditaJpaRepository.save(puntoVenditaFactory.resourceToEntity(pvr, a));
			}
		}
		
		return aziendaResource;
	}

	@Override
	public List<PuntoVenditaRequest> saveAll(List<PuntoVendita> listPuntoVendita) {
		puntoVenditaJpaRepository.saveAll(listPuntoVendita);
		return puntoVenditaFactory.entityToResource(listPuntoVendita);
	}

	@Override
	public AziendaRequest updatePuntiVendita(AziendaRequest aziendaResource) throws Exception {
		log.info("call updatePuntoVendita");

		Azienda a = null;
		PuntoVendita pv = null;
		boolean search = true;

		if(!CollectionUtils.isEmpty(aziendaResource.getPuntiVendita())){
			for(PuntoVenditaRequest pvr : aziendaResource.getPuntiVendita()) {

				if(search) { // cerco una sola volta l'azienda del punto vendita
					search = false;
					pv = puntoVenditaJpaRepository.findByIdIdentifier(pvr.getIdIdentifier());

					if(null != pv) { // se esiste mi vado a prendere azienda
						a = pv.getAzienda();
					} else { // altrimenti scatto un Exception TODO da fare una coustom exception 
						throw new Exception();
					}
				}
				puntoVenditaJpaRepository.save(puntoVenditaFactory.resourceToEntity(pvr, a));

			}
		} else {
			throw new Exception("input without list of puntiVendita, please re-try");
		}

		log.info("end updatePuntoVendita");
		return aziendaResource;
	}

	@Override
	public String deletePuntoVendita(String idIdentifier) {
		PuntoVendita pv = puntoVenditaJpaRepository.findByIdIdentifier(idIdentifier);
		
		puntoVenditaJpaRepository.delete(pv);
		
		return "delete retailoutlet with id : " + idIdentifier;
	}
	
	private AziendaRequest setResponse(List<PuntoVendita> listEntity) {
		AziendaRequest response = new AziendaRequest();
		if(!CollectionUtils.isEmpty(listEntity)) { // 
			response = AziendaRequest.builder()
						.citta(listEntity.get(0).getAzienda().getCitta())
						.idIdentifier(listEntity.get(0).getAzienda().getIdIdentifier())
						.nomeAzienda(listEntity.get(0).getAzienda().getNomeAzienda())
						.puntiVendita(puntoVenditaFactory.entityToResource(listEntity))
						.regione(listEntity.get(0).getAzienda().getRegione())
						.build();
			for(PuntoVenditaRequest pvr : response.getPuntiVendita()) {
				pvr.setListFedelityCard(fedelityCardFactory.entityToResource(
						Utility.findMatchingPuntoVedinta(pvr, listEntity) // find entity puntovendita from idIdentifier resource dto
							.getCarteFedelta() // get list card
						));
			}
			
		}
		return response;
	}

}

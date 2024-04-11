package com.supermarket.fedelity.card.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
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

	@Override
	public CreazioneAziendaRequest updatePuntiVendita(CreazioneAziendaRequest aziendaResource) throws Exception {
		log.info("call updatePuntoVendita");
		
		Azienda a = null;
		PuntoVendita pv = null;
		boolean search = true;

		for (AziendaRequest ar : aziendaResource.getAzienda()) {
			search = true;
			if(!CollectionUtils.isEmpty(ar.getPuntiVendita())){
				for(PuntoVenditaRequest pvr : ar.getPuntiVendita()) {
					
					if(search) { // cerco una sola sola l'azienda del punto vendita
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
				
			}
		}

		log.info("end updatePuntoVendita");
		return aziendaResource;
	}

}

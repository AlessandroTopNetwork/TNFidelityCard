package com.supermarket.fedelity.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.service.PuntoVenditaService;

@RestController
@RequestMapping(value = "/pointsaleservice")
public class ControllerRetailOutlet {
	
	@Autowired
	private PuntoVenditaService servicePuntoVendita;
	
	@PutMapping(value = "/retailoutlet")
	public CreazioneAziendaRequest updateRetailOutlet(@RequestBody CreazioneAziendaRequest aziendaResource) throws Exception {
		return servicePuntoVendita.updatePuntiVendita(aziendaResource);
	}

}

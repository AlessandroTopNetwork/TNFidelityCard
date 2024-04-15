package com.supermarket.fedelity.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.fedelity.card.dto.request.azienda.AziendaRequest;
import com.supermarket.fedelity.card.service.PuntoVenditaService;

@RestController
@RequestMapping(value = "/pointsaleservice")
public class ControllerRetailOutlet {
	
	@Autowired
	private PuntoVenditaService servicePuntoVendita;
	
	@GetMapping(value = "/retailoutlets/{idIdentifierAzienda}")
	public AziendaRequest getAllRetailOutlet(@PathVariable String idIdentifierAzienda) throws Exception {
		return servicePuntoVendita.getPuntiVendita(idIdentifierAzienda);
	}
	
	@GetMapping(value = "/retailoutlet/{idIdentifierRetailOutlet}")
	public AziendaRequest getRetailOutlet(@PathVariable String idIdentifierRetailOutlet) throws Exception {
		return servicePuntoVendita.findByIdIdentifier(idIdentifierRetailOutlet);
	}
	
	@PutMapping(value = "/retailoutlet")
	public AziendaRequest updateRetailOutlet(@RequestBody AziendaRequest aziendaResource) throws Exception {
		return servicePuntoVendita.updatePuntiVendita(aziendaResource);
	}
	
	@PostMapping(value = "/retailoutlet")
	public AziendaRequest insertRetailOutlet(@RequestBody AziendaRequest aziendaResource) throws Exception {
		return servicePuntoVendita.createPuntiVendita(aziendaResource);
	}
	
	@DeleteMapping(value = "/retailoutlet/{idIdentifierRetailOutlet}")
	public String deleteRetailOutlet(@PathVariable String idIdentifierRetailOutlet) throws Exception {
		return servicePuntoVendita.deletePuntoVendita(idIdentifierRetailOutlet);
	}

}

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

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;

@RestController
@RequestMapping(value = "/fedelitycardservice")
public class ControllerFedelityCard {
	
	@Autowired
	private ServiceFedelityCard serviceFedelityCard;
	
	@GetMapping(value = "/fedelityCards")
	public CreazioneAziendaRequest getfedelityCard() throws Exception {
		return serviceFedelityCard.getAziende();
	}
	
	@GetMapping(value = "/fedelityCard/{idIdentifier}")
	public CreazioneAziendaRequest getfedelityCard(@PathVariable String idIdentifier) throws Exception {
		return serviceFedelityCard.findByIdIdentifier(idIdentifier);
	}
	
//	@GetMapping(value = "/fedelityCards/{numeroTessera}")
//	public List<ClienteRequest> getfedelityCardAndCardByIdCard(@PathVariable String numeroTessera) throws Exception {
//		return serviceAzienda.getListClientiFindByNumeroCarta(numeroTessera);
//	}
	
	@PostMapping(value = "/fedelityCard") // create only azienda and punti vendita // work
	public CreazioneAziendaRequest registerAzienda(@RequestBody CreazioneAziendaRequest azienda) throws Exception {
		return serviceFedelityCard.createAziendaAndRetailOutlet(azienda);
	}
	
	@PutMapping(value = "/fedelityCard")
	public CreazioneAziendaRequest modifyfedelityCard(@RequestBody CreazioneAziendaRequest azienda) { // work
		return serviceFedelityCard.updateAzienda(azienda);
	}
	
	@DeleteMapping(value = "/fedelityCard")
	public String deletefedelityCard() {
		return "";
	}

}

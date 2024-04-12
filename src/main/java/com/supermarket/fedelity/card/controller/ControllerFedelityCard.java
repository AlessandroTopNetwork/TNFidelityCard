package com.supermarket.fedelity.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.service.FedelityCardService;

@RestController
@RequestMapping(value = "/fedelitycardservice")
public class ControllerFedelityCard { // crud complete
	
	@Autowired
	private FedelityCardService fedelityCardService;
	
	@GetMapping(value = "/fedelityCards")
	public List<FedelityCardRequest> getfedelityCardByIdIdentifierPuntoVendita(@PathVariable String idIdentifierPuntoVendita) {
		return fedelityCardService.getAllFedelityCardByPuntoVendita(idIdentifierPuntoVendita);
	}
	
	@GetMapping(value = "/fedelityCard/{numeroTessera}")
	public FedelityCardRequest getfedelityCard(@PathVariable String numeroTessera) throws Exception {
		return fedelityCardService.findByNumeroTessera(numeroTessera);
	}
	
//	@GetMapping(value = "/fedelityCards/{numeroTessera}")
//	public List<ClienteRequest> getfedelityCardAndCardByIdCard(@PathVariable String numeroTessera) throws Exception {
//		return serviceAzienda.getListClientiFindByNumeroCarta(numeroTessera);
//	}
	
	@PostMapping(value = "/fedelityCard/{idIdentifierPuntoVendita}") // create only azienda and punti vendita // work
	public FedelityCardRequest registerFedelityCard(@PathVariable String idIdentifierPuntoVendita, @RequestBody FedelityCardRequest fedelityCard) throws Exception {
		return fedelityCardService.createFedelityCard(fedelityCard, idIdentifierPuntoVendita);
	}
	
	@PutMapping(value = "/fedelityCard")
	public FedelityCardRequest modifyFedelityCard(@RequestBody FedelityCardRequest fedelityCard) { // work
		return fedelityCardService.updateFedelityCard(fedelityCard);
	}
	
	@DeleteMapping(value = "/fedelityCard/{numeroTessera}")
	public String deleteFedelityCard(@PathVariable String numeroTessera) {
		fedelityCardService.deleteFedelityCard(numeroTessera);
		return "test";
	}

}

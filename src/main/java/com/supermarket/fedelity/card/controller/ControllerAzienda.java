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
import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.service.ServiceAzienda;

@RestController
@RequestMapping(value = "/companyservice")
public class ControllerAzienda {
	
	@Autowired
	private ServiceAzienda serviceAzienda;
	
	@GetMapping(value = "/companys")
	public CreazioneAziendaRequest getCompany() throws Exception {
		return serviceAzienda.getAziende();
	}
	
	@GetMapping(value = "/company/{idIdentifier}")
	public AziendaRequest getCompany(@PathVariable String idIdentifier) throws Exception {
		return serviceAzienda.findByIdIdentifier(idIdentifier);
	}
	
//	@GetMapping(value = "/companys/{numeroTessera}")
//	public List<ClienteRequest> getcompanyAndCardByIdCard(@PathVariable String numeroTessera) throws Exception {
//		return serviceAzienda.getListClientiFindByNumeroCarta(numeroTessera);
//	}
	
	@PostMapping(value = "/company") // create only azienda and punti vendita // work
	public CreazioneAziendaRequest registerAzienda(@RequestBody CreazioneAziendaRequest azienda) throws Exception {
		return serviceAzienda.createAziendaAndRetailOutlet(azienda);
	}
	
	@PutMapping(value = "/company")
	public CreazioneAziendaRequest modifyCompany(@RequestBody CreazioneAziendaRequest azienda) { // work
		return serviceAzienda.updateAzienda(azienda);
	}
	
	@DeleteMapping(value = "/company")
	public String deleteCompany() {
		return "";
	}

}

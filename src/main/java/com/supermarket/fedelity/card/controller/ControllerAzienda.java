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

import com.supermarket.fedelity.card.dto.request.azienda.CreazioneAziendaRequest;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.serviceinterface.ServiceAzienda;

@RestController
@RequestMapping(value = "/companyservice")
public class ControllerAzienda {
	
	@Autowired
	private ServiceAzienda serviceAzienda;
	
	@GetMapping(value = "/companys")
	public List<CreazioneAziendaRequest> getCompany() throws Exception {
		return serviceAzienda.getAziende();
	}
	
	@GetMapping(value = "/company/{id}")
	public CreazioneAziendaRequest getCompany(@PathVariable long id) throws Exception {
		return serviceAzienda.findById(id);
	}
	
//	@GetMapping(value = "/companys/{numeroTessera}")
//	public List<ClienteRequest> getcompanyAndCardByIdCard(@PathVariable String numeroTessera) throws Exception {
//		return serviceAzienda.getListClientiFindByNumeroCarta(numeroTessera);
//	}
	
	@PostMapping(value = "/company")
	public CreazioneAziendaRequest registerCard(@RequestBody CreazioneAziendaRequest azienda) throws Exception {
		return serviceAzienda.createAzienda(azienda);
	}
	
	@PutMapping(value = "/company")
	public String modifyCompany() {
		return "test";
	}
	
	@DeleteMapping(value = "/company")
	public String deleteCompany() {
		return "";
	}

}

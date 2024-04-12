package com.supermarket.fedelity.card.dto.request.azienda.puntovendita;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.TipologiaAziendaRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntoVenditaRequest {

	private String nomePuntoVendita;
	
	private String citta;
	
	private String regione;
	
	private String idIdentifier;

	private TipologiaAziendaRequest tipoAzienda;
	
	private List<FedelityCardRequest> listFedelityCard;

}

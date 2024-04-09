package com.supermarket.fedelity.card.dto.request.azienda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipologiaAziendaRequest {

	private String tipoAzienda;
	
	private String descrizione;

}

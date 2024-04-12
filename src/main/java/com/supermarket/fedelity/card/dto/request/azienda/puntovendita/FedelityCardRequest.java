package com.supermarket.fedelity.card.dto.request.azienda.puntovendita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FedelityCardRequest {

	private String numeroTessera;
	
	private long punti;
	
	private String puntoVenditaNome;
	
	private String idIdentifer;

}

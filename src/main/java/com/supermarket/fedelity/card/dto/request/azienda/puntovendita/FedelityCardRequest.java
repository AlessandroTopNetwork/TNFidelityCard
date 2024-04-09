package com.supermarket.fedelity.card.dto.request.azienda.puntovendita;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.cliente.ClienteRequest;

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
	
	private String dataCreazioneTessera;
	
	private long punti;
	
	private String puntoVenditaNome;
	
    private List<ClienteRequest> clienti;

}

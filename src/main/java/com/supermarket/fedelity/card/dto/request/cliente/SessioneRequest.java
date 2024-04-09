package com.supermarket.fedelity.card.dto.request.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessioneRequest { // da non mandare fuori con gli end point suppongo TODO
	
	private String dataInizio;
	
	private String dataFine;
	
	private ClienteRequest cliente;
	
}
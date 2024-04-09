package com.supermarket.fedelity.card.dto.request.cliente;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.enumeration.ETipologiaCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {

	private String nome;
	
	private String cognome;
	
	private String indirizzo;
	
	private String numeroTelefono;
	
	private String email;
	
	private String dataTesseramento;
	
	private String numeroTessera;
	
	private String storiciAcquisti;
	
    private FedelityCardRequest fedelityCard;
    
    private ETipologiaCliente tipoCliente;

}

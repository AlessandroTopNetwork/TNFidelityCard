package com.supermarket.fedelity.card.dto.request.azienda;

public class TipologiaAziendaRequest {

	private String tipoCliente;
	
	private String descrizione;
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public String toString() {
		return "TipologiaAziendaRequest [tipoCliente=" + tipoCliente + ", descrizione=" + descrizione + "]";
	}

}

package com.supermarket.fedelity.card.dto.request;

import java.util.List;

public class FedelityCardRequest {

	private String numeroTessera;
	private String dataCreazioneTessera;
	private long punti;
	private String puntoVenditaNome;
    private List<ClienteRequest> clienti;

	public String getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public String getDataCreazioneTessera() {
		return dataCreazioneTessera;
	}

	public void setDataCreazioneTessera(String dataCreazioneTessera) {
		this.dataCreazioneTessera = dataCreazioneTessera;
	}

	public long getPunti() {
		return punti;
	}

	public void setPunti(long punti) {
		this.punti = punti;
	}

	public List<ClienteRequest> getCliente() {
		return clienti;
	}

	public void setCliente(List<ClienteRequest> cliente) {
		this.clienti = cliente;
	}

	public String getPuntoVenditaNome() {
		return puntoVenditaNome;
	}

	public void setPuntoVenditaNome(String puntoVenditaNome) {
		this.puntoVenditaNome = puntoVenditaNome;
	}

}

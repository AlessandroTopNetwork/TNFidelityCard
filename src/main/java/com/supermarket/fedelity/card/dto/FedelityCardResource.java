package com.supermarket.fedelity.card.dto;

import java.util.List;

public class FedelityCardResource extends BaseResource {

	private String numeroTessera;
	private String dataCreazioneTessera;
	private long punti;
	private long idPuntoVendita;
    private List<ClienteResource> clienti;

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

	public List<ClienteResource> getCliente() {
		return clienti;
	}

	public void setCliente(List<ClienteResource> cliente) {
		this.clienti = cliente;
	}

	public long getIdPuntoVendita() {
		return idPuntoVendita;
	}

	public void setIdPuntoVendita(long idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}

}

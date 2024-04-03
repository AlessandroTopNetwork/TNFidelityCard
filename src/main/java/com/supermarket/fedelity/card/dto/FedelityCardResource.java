package com.supermarket.fedelity.card.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.entity.ErrorEntity;
import com.supermarket.fedelity.card.entity.FedelityCard;

public class FedelityCardResource extends BaseResource {

	private String numeroTessera;
	private String dataCreazioneTessera;
	private long punti;
	private String puntoVenditaNome;
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

	public String getPuntoVenditaNome() {
		return puntoVenditaNome;
	}

	public void setPuntoVenditaNome(String puntoVenditaNome) {
		this.puntoVenditaNome = puntoVenditaNome;
	}

}

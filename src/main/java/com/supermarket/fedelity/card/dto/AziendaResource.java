package com.supermarket.fedelity.card.dto;

import java.util.List;

public class AziendaResource extends BaseResource {

    private String nomeAzienda;
    private String regione;
    private String citta;
    private List<PuntoVenditaResource> puntiVendita;

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

	public List<PuntoVenditaResource> getPuntiVendita() {
		return puntiVendita;
	}

	public void setPuntiVendita(List<PuntoVenditaResource> puntiVendita) {
		this.puntiVendita = puntiVendita;
	}

	@Override
	public String toString() {
		return "AziendaResoure [nomeAzienda=" + nomeAzienda + ", regione=" + regione + ", citta=" + citta
				+ ", puntiVendita=" + puntiVendita + "]";
	}

}

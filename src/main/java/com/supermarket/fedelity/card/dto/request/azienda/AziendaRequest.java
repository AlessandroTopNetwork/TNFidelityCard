package com.supermarket.fedelity.card.dto.request.azienda;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;

public class AziendaRequest {

    private String nomeAzienda;
    
    private String regione;
    
    private String citta;
    
    private List<PuntoVenditaRequest> puntiVendita;
    
	private TipologiaAziendaRequest tipoAzienda;

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

	public List<PuntoVenditaRequest> getPuntiVendita() {
		return puntiVendita;
	}

	public void setPuntiVendita(List<PuntoVenditaRequest> puntiVendita) {
		this.puntiVendita = puntiVendita;
	}

	@Override
	public String toString() {
		return "AziendaResoure [nomeAzienda=" + nomeAzienda + ", regione=" + regione + ", citta=" + citta
				+ ", puntiVendita=" + puntiVendita + "]";
	}

}

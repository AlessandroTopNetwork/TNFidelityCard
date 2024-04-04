package com.supermarket.fedelity.card.dto.request;

public class PuntoVenditaRequest {

    private String nomePuntoVendita;
    private String citta;
    private String regione;
    private String nomeAzienda;

    public String getNomePuntoVendita() {
        return nomePuntoVendita;
    }

    public void setNomePuntoVendita(String nomePuntoVendita) {
        this.nomePuntoVendita = nomePuntoVendita;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

	@Override
	public String toString() {
		return "PuntoVenditaResource [nomePuntoVendita=" + nomePuntoVendita + ", citta=" + citta + ", regione="
				+ regione + ", azienda=" + nomeAzienda + "]";
	}    
    
}

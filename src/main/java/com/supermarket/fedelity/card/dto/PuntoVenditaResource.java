package com.supermarket.fedelity.card.dto;

public class PuntoVenditaResource extends BaseResource {

    private String nomePuntoVendita;
    private String citta;
    private String regione;
    private AziendaResoure azienda;

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

    public AziendaResoure getAzienda() {
        return azienda;
    }

    public void setAzienda(AziendaResoure azienda) {
        this.azienda = azienda;
    }

	@Override
	public String toString() {
		return "PuntoVenditaResource [nomePuntoVendita=" + nomePuntoVendita + ", citta=" + citta + ", regione="
				+ regione + ", azienda=" + azienda + "]";
	}    
    
}

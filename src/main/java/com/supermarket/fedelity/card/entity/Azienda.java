package com.supermarket.fedelity.card.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "azienda")
public class Azienda extends BaseEntity {
	
    @Id
	@Column(name = "id_azienda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAzienda;

    @Column(name = "nome")
    private String nomeAzienda;

    @Column(name = "Regione")
    private String regione;

    @Column(name = "citta")
    private String citta;

    @OneToMany
    @JoinColumn(name = "punto_vendita_id")
    private List<PuntoVendita> puntiVendita;

    public Long getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Long idAzienda) {
        this.idAzienda = idAzienda;
    }

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

    public List<PuntoVendita> getPuntoVendita() {
        return puntiVendita;
    }

    public void setPuntoVendita(List<PuntoVendita> puntoVendita) {
        this.puntiVendita = puntoVendita;
    }
    
//    public AziendaResource aziendaToResource(Azienda a) {
//    	
//    	AziendaResource ar = new AziendaResource();
//    	
//    	ar.setCitta(a.getCitta());
//    	ar.setNomeAzienda(a.getNomeAzienda());
//    	if(null != a.puntiVendita || !a.getPuntoVendita().isEmpty()) {
//        	ar.setPuntiVendita(a.getPuntoVendita().get(0).puntoVenditaToResource(a.getPuntoVendita())); // per evitare di fare un istanza di puntiVEndita extra
//    	}
//    	ar.setRegione(a.getRegione());
//    	
//    	return ar;
//    	
//    }

    @Override
    public String toString() {
        return "Azienda [idAzienda=" + idAzienda + ", nomeAzienda=" + nomeAzienda + ", regione=" + regione + ", citta=" + citta + ", puntoVendita=" + puntiVendita + "]";
    }
}

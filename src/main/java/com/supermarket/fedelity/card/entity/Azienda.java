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

    @Override
    public String toString() {
        return "Azienda [idAzienda=" + idAzienda + ", nomeAzienda=" + nomeAzienda + ", regione=" + regione + ", citta=" + citta + ", puntoVendita=" + puntiVendita + "]";
    }
}

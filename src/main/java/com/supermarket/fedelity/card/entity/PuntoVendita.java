package com.supermarket.fedelity.card.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "punto_vendita")
public class PuntoVendita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punto_vendita")
    private Long idPuntoVendita;

    @Column(name = "nome_punto_vendita")
    private String nomePuntoVendita;

    @Column(name = "citta")
    private String citta;

    @Column(name = "regione")
    private String regione;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    private Azienda azienda;

    public Long getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public void setIdPuntoVendita(Long idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

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

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    @Override
    public String toString() {
        return "PuntoVendita{" +
                "idPuntoVendita=" + idPuntoVendita +
                ", nomePuntoVendita='" + nomePuntoVendita + '\'' +
                ", citta='" + citta + '\'' +
                ", regione='" + regione + '\'' +
                ", azienda=" + azienda +
                '}';
    }
}

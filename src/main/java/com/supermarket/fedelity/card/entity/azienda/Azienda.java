package com.supermarket.fedelity.card.entity.azienda;

import java.util.List;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "azienda")
public class Azienda {
	
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
    
    @ManyToOne
    @JoinColumn(name = "tipo_azienda_id")
    private TipologiaAzienda tipoCliente;

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

	public TipologiaAzienda getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipologiaAzienda tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Azienda [idAzienda=" + idAzienda + ", nomeAzienda=" + nomeAzienda + ", regione=" + regione + ", citta="
				+ citta + ", tipoCliente=" + tipoCliente + "]";
	}

}

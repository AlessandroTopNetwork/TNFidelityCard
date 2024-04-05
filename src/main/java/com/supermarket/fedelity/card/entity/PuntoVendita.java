package com.supermarket.fedelity.card.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "punto_vendita")
public class PuntoVendita extends BaseEntity {

	@Id
	@Column(name = "id_punto_vendita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuntoVendita;

	@Column(name = "nome_punto_vendita")
	private String nomePuntoVendita;

	@Column(name = "citta")
	private String citta;

	@Column(name = "regione")
	private String regione;

	@ManyToOne
	@JoinColumn(name = "azienda_id")
	@JsonBackReference
	private Azienda azienda;
	
   @ManyToMany(mappedBy = "puntiVendita")
    private List<FedelityCard> carteFedelta;

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

	public List<FedelityCard> getCarteFedelta() {
		return carteFedelta;
	}

	public void setCarteFedelta(List<FedelityCard> carteFedelta) {
		this.carteFedelta = carteFedelta;
	}

	@Override
	public String toString() {
		return "PuntoVendita{" + "idPuntoVendita=" + idPuntoVendita + ", nomePuntoVendita='" + nomePuntoVendita + '\''
				+ ", citta='" + citta + '\'' + ", regione='" + regione + '}';
	}
}

package com.supermarket.fedelity.card.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carta_fedelta")
public class FedelityCard extends BaseEntity {

	@Id
	@Column(name = "id_carta_fedelta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Numero_tessera", nullable = false)
	private String numeroTessera;

	@Column(name = "Data_di_creazione_tessera")
	private OffsetDateTime dataCreazioneTessera;

	@Column(name = "punti")
	private long punti;

	@OneToMany
	@JoinColumn(name = "carta_fedelta_id")
	@JsonBackReference
	private List<Cliente> clienti;

	@ManyToMany
	@JoinTable(
			name = "punto_vendita",
			joinColumns = @JoinColumn(name = "id_punto_vendita"),
			inverseJoinColumns = @JoinColumn(name = "punto_vendita_id")
			)
	private List<PuntoVendita> puntiVendita;

	public FedelityCard() {
	}

//	public FedelityCard(long id, String numeroTessera, long punti, List<PuntoVendita> puntoVendita) { // only test
//		this.id = id;
//		this.numeroTessera = numeroTessera;
////		this.dataCreazioneTessera = dataCreazioneTessera;
//		this.punti = punti;
//		this.puntoVendita = puntoVendita;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public OffsetDateTime getDataCreazioneTessera() {
		return dataCreazioneTessera;
	}

	public void setDataCreazioneTessera(OffsetDateTime dataCreazioneTessera) {
		this.dataCreazioneTessera = dataCreazioneTessera;
	}

	public long getPunti() {
		return punti;
	}

	public void setPunti(long punti) {
		this.punti = punti;
	}

	public List<Cliente> getClienti() {
		if(!CollectionUtils.isEmpty(clienti)) {
			return clienti;
		}
		return new ArrayList<Cliente>();
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}

	public List<PuntoVendita> getPuntiVendita() {
		return puntiVendita;
	}

	public void setPuntiVendita(List<PuntoVendita> puntiVendita) {
		this.puntiVendita = puntiVendita;
	}

	@Override
	public String toString() {
		return "FedelityCard [id=" + id + ", numeroTessera=" + numeroTessera + ", dataCreazioneTessera="
				+ dataCreazioneTessera + ", punti=" + punti + ", clienti= [" + clienti + "], idPuntoVendita="
				+ puntiVendita + "]";
	}

}

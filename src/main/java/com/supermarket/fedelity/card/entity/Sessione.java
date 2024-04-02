package com.supermarket.fedelity.card.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessione_acquisto")
public class Sessione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_inizio")
	private OffsetDateTime dataInizio;

	@Column(name = "data_fine")
	private OffsetDateTime dataFine;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(OffsetDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public OffsetDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(OffsetDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@PreUpdate
	private void preUpdate() {
		this.dataFine = OffsetDateTime.now();
	}

	@Override
	public String toString() {
		return "Sessione [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", cliente=" + cliente
				+ "]";
	}
	
}

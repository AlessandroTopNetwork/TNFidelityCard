package com.supermarket.fedelity.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_cliente")
public class TipoCliente {

	@Id
	@Column(name = "id_tipo_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "tipo_cliente")
	private String tipoCliente;

	@Column(name = "descrizione")
	private String descrizione;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "TipoCliente [id=" + id + ", tipoCliente=" + tipoCliente + ", descrizione=" + descrizione + "]";
	}
	
}

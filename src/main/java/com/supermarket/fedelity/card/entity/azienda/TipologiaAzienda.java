package com.supermarket.fedelity.card.entity.azienda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_azienda")
public class TipologiaAzienda {

	@Id
	@Column(name = "id_tipo_azienda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "tipo_azienda")
	private String tipoAzienda;

	@Column(name = "descrizione")
	private String descrizione;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(String tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "TipologiaAzienda [id=" + id + ", tipoCliente=" + tipoAzienda + ", descrizione=" + descrizione + "]";
	}
	
}

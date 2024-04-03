package com.supermarket.fedelity.card.entity;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carta_fedelta")
public class FedelityCard extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Numero_tessera", nullable = false)
    private String numeroTessera;

    @Column(name = "Data_di_creazione_tessera")
    private OffsetDateTime dataCreazioneTessera;

    @Column(name = "punti")
    private long punti;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @Column(name = "punto_vendita_id")
    private long idPuntoVendita;
    
    public FedelityCard() {}
    
	public FedelityCard(long id, String numeroTessera, long punti,
			long idPuntoVendita) { // only test 
		this.id = id;
		this.numeroTessera = numeroTessera;
//		this.dataCreazioneTessera = dataCreazioneTessera;
		this.punti = punti;
		this.idPuntoVendita = idPuntoVendita;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getIdPuntoVendita() {
		return idPuntoVendita;
	}

	public void setIdPuntoVendita(long idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}

	@Override
	public String toString() {
		return "FedelityCard [id=" + id + ", numeroTessera=" + numeroTessera + ", dataCreazioneTessera="
				+ dataCreazioneTessera + ", punti=" + punti + ", cliente=" + cliente + ", idPuntoVendita="
				+ idPuntoVendita + "]";
	}

}

package com.supermarket.fedelity.card.entity.tabraccordo;

import com.supermarket.fedelity.card.entity.FedelityCard;
import com.supermarket.fedelity.card.entity.PuntoVendita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "raccordo_carta_fedelta_punto_vendita")
public class RaccordoCartaPuntoVendita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_raccordo_carta_fedelta_punto_vendita")
	private Long id;

	@Id
	@ManyToOne
	@JoinColumn(name = "carta_fedelta_racc_id")
	private FedelityCard cartaFedelta;

	@Id
	@ManyToOne
	@JoinColumn(name = "punto_vendita_racc_id")
	private PuntoVendita puntoVendita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FedelityCard getCartaFedelta() {
		return cartaFedelta;
	}

	public void setCartaFedelta(FedelityCard cartaFedelta) {
		this.cartaFedelta = cartaFedelta;
	}

	public PuntoVendita getPuntoVendita() {
		return puntoVendita;
	}

	public void setPuntoVendita(PuntoVendita puntoVendita) {
		this.puntoVendita = puntoVendita;
	}

	@Override
	public String toString() {
		return "RaccordoCartaPuntoVendita [id=" + id + ", cartaFedelta=" + cartaFedelta + ", puntoVendita="
				+ puntoVendita + "]";
	}
	
}

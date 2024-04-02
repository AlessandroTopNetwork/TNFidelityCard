package com.supermarket.fedelity.card.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "numero_telefono")
	private String numeroTelefono;

	@Column(name = "email")
	private String email;

	@Column(name = "data_tesseramento")
	private Timestamp dataTesseramento;

	@Column(name = "numero_essera")
	private String numeroTessera;

	@Column(name = "storici_acquisti")
	private String storiciAcquisti;

}

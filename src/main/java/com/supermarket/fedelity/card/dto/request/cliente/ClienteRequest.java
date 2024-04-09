package com.supermarket.fedelity.card.dto.request.cliente;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.FedelityCardRequest;
import com.supermarket.fedelity.card.entity.enumeration.ETipologiaCliente;

public class ClienteRequest {

	private String nome;
	private String cognome;
	private String indirizzo;
	private String numeroTelefono;
	private String email;
	private String dataTesseramento;
	private String numeroTessera;
	private String storiciAcquisti;
    private FedelityCardRequest fedelityCard;
    private ETipologiaCliente tipoCliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataTesseramento() {
		return dataTesseramento;
	}

	public void setDataTesseramento(String dataTesseramento) {
		this.dataTesseramento = dataTesseramento;
	}

	public String getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public String getStoriciAcquisti() {
		return storiciAcquisti;
	}

	public void setStoriciAcquisti(String storiciAcquisti) {
		this.storiciAcquisti = storiciAcquisti;
	}

	public FedelityCardRequest getFedelityCard() {
		return fedelityCard;
	}

	public void setFedelityCard(FedelityCardRequest fedelityCard) {
		this.fedelityCard = fedelityCard;
	}

	public ETipologiaCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(ETipologiaCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "ClienteResource [nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
				+ ", numeroTelefono=" + numeroTelefono + ", email=" + email + ", dataTesseramento=" + dataTesseramento
				+ ", numeroTessera=" + numeroTessera + ", storiciAcquisti=" + storiciAcquisti + ", fedelityCard="
				+ fedelityCard + "]";
	}

}

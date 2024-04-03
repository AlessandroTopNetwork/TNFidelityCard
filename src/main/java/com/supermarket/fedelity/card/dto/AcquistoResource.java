package com.supermarket.fedelity.card.dto;

import java.math.BigDecimal;

public class AcquistoResource extends BaseResource {
	
	private String idProdotto;
    private String nomeProdotto;
    private BigDecimal prezzoProdotto;
    private ClienteResource cliente;

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public BigDecimal getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(BigDecimal prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public ClienteResource getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResource cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "AcquistoResource [idProdotto=" + idProdotto + ", nomeProdotto=" + nomeProdotto + ", prezzoProdotto="
				+ prezzoProdotto + ", cliente=" + cliente + "]";
	}

}

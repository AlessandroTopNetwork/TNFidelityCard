package com.supermarket.fedelity.card.entity;

import java.math.BigDecimal;

import com.supermarket.fedelity.card.dto.AcquistoResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "acquisto")
public class Acquisto extends BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_prodotto")
    private String idProdotto;

    @Column(name = "nome_prodotto")
    private String nomeProdotto;

    @Column(name = "prezzo_prodotto")
    private BigDecimal prezzoProdotto;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
    public AcquistoResource aziendaToResource(Acquisto acquisto) {
    	
    	AcquistoResource ac = new AcquistoResource();
    	

    	
    	return ac;
    	
    }

	@Override
	public String toString() {
		return "Acquisto [id=" + id + ", idProdotto=" + idProdotto + ", nomeProdotto=" + nomeProdotto
				+ ", prezzoProdotto=" + prezzoProdotto + ", cliente=" + cliente + "]";
	}

}

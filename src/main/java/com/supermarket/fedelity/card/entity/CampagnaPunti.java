package com.supermarket.fedelity.card.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campagna_punti")
public class CampagnaPunti {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_campagna", nullable = false)
    private String nomeCampagna;

    @Column(name = "data_inizio")
    private OffsetDateTime dataInizio;

    @Column(name = "data_fine")
    private OffsetDateTime dataFine;

    @Column(name = "donversione_punti_euro", precision = 10, scale = 2)
    private BigDecimal conversionePuntiEuro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCampagna() {
		return nomeCampagna;
	}

	public void setNomeCampagna(String nomeCampagna) {
		this.nomeCampagna = nomeCampagna;
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

	public BigDecimal getConversionePuntiEuro() {
		return conversionePuntiEuro;
	}

	public void setConversionePuntiEuro(BigDecimal conversionePuntiEuro) {
		this.conversionePuntiEuro = conversionePuntiEuro;
	}

	@Override
	public String toString() {
		return "CampagnaPunti [id=" + id + ", nomeCampagna=" + nomeCampagna + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + ", conversionePuntiEuro=" + conversionePuntiEuro + "]";
	}

}

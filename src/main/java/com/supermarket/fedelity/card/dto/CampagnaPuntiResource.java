package com.supermarket.fedelity.card.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class CampagnaPuntiResource extends BaseResource {

    private String nomeCampagna;
    private OffsetDateTime dataInizio;
    private OffsetDateTime dataFine;
    private BigDecimal conversionePuntiEuro;

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
		return "CampagnaPuntiResource [nomeCampagna=" + nomeCampagna + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", conversionePuntiEuro=" + conversionePuntiEuro + "]";
	}

}

package com.supermarket.fedelity.card.dto.request.azienda;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;

public class CreazioneAziendaRequest {
	
	private AziendaRequest azienda;
	
	private TipologiaAziendaRequest tipoAzienda;
	
	private List<PuntoVenditaRequest> listPuntiVendita;

	public AziendaRequest getAzienda() {
		return azienda;
	}

	public void setAzienda(AziendaRequest azienda) {
		this.azienda = azienda;
	}

	public TipologiaAziendaRequest getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipologiaAziendaRequest tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public List<PuntoVenditaRequest> getListPuntiVendita() {
		return listPuntiVendita;
	}

	public void setListPuntiVendita(List<PuntoVenditaRequest> listPuntiVendita) {
		this.listPuntiVendita = listPuntiVendita;
	}

	@Override
	public String toString() {
		return "CreazioneAziendaRequest [azienda=" + azienda + ", tipoAzienda=" + tipoAzienda + ", listPuntiVendita="
				+ listPuntiVendita + "]";
	}	

}

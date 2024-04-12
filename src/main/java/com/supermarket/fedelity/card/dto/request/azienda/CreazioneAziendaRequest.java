package com.supermarket.fedelity.card.dto.request.azienda;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreazioneAziendaRequest {
	
	private List<AziendaRequest> aziende;

}

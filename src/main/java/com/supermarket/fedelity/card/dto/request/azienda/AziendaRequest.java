package com.supermarket.fedelity.card.dto.request.azienda;

import java.util.List;

import com.supermarket.fedelity.card.dto.request.azienda.puntovendita.PuntoVenditaRequest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AziendaRequest {

    private String nomeAzienda;
    
    private String regione;
    
    private String citta;
    
    private String idIdentifier;
    
    private List<PuntoVenditaRequest> puntiVendita;

}

package com.supermarket.fedelity.card.dto.request.azienda.puntovendita;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampagnaPuntiRequest {

    private String nomeCampagna;
    
    private OffsetDateTime dataInizio;
    
    private OffsetDateTime dataFine;
    
    private BigDecimal conversionePuntiEuro;

}

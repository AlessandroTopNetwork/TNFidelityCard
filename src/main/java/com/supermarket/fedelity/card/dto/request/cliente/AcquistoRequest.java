package com.supermarket.fedelity.card.dto.request.cliente;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcquistoRequest {
	
	private String idProdotto;
	
    private String nomeProdotto;
    
    private BigDecimal prezzoProdotto;
    
    private ClienteRequest cliente;

}

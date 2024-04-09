package com.supermarket.fedelity.card.entity.azienda.puntovendita;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.entity.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campagna_punti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampagnaPunti {
	
	@Id
	@Column(name = "id_campgna_punti")
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

}

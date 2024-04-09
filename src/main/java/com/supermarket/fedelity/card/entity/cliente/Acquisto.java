package com.supermarket.fedelity.card.entity.cliente;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.dto.request.cliente.AcquistoRequest;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acquisto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Acquisto {
	
    @Id
	@Column(name = "id_acquisto")
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

}

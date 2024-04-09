package com.supermarket.fedelity.card.entity.cliente;

import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sessione_acquisto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sessione {

	@Id
	@Column(name = "id_sessione_acquisto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_inizio")
	private OffsetDateTime dataInizio;

	@Column(name = "data_fine")
	private OffsetDateTime dataFine;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

}

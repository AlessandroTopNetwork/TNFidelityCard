package com.supermarket.fedelity.card.entity.azienda;

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
@Table(name = "tipo_azienda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipologiaAzienda {

	@Id
	@Column(name = "id_tipo_azienda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "tipo_azienda")
	private String tipoAzienda;

	@Column(name = "descrizione")
	private String descrizione;
	
}

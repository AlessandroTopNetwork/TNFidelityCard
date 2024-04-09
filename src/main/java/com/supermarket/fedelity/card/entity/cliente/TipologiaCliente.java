package com.supermarket.fedelity.card.entity.cliente;

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
@Table(name = "tipo_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipologiaCliente {

	@Id
	@Column(name = "id_tipo_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "tipo_cliente")
	private String tipoCliente;

	@Column(name = "descrizione")
	private String descrizione;

}

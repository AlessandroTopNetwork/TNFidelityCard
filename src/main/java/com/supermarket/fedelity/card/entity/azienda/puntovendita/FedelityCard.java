package com.supermarket.fedelity.card.entity.azienda.puntovendita;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carta_fedelta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FedelityCard {

	@Id
	@Column(name = "id_carta_fedelta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "numero_tessera", nullable = false)
	private String numeroTessera;

	@Column(name = "data_di_creazione_tessera")
	private OffsetDateTime dataCreazioneTessera;

	@Column(name = "punti")
	private long punti;

	@OneToMany
	@JoinColumn(name = "carta_fedelta_id")
	private List<Cliente> clienti;
	
	@ManyToOne
	@JoinColumn(name = "punto_vendita_id") // collonna sulla tab in essere
    private PuntoVendita puntoVendita;
	
	@ManyToOne
	@JoinColumn(name = "azienda_id")
	@JsonBackReference
	private Azienda azienda;
	
	@PrePersist
	private void setDateCreate() {
		dataCreazioneTessera = OffsetDateTime.now();
	}

}

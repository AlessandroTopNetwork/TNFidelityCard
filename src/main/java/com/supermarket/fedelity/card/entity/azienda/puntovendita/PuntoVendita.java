package com.supermarket.fedelity.card.entity.azienda.puntovendita;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.supermarket.fedelity.card.entity.azienda.Azienda;
import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "punto_vendita")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder	
public class PuntoVendita {

	@Id
	@Column(name = "id_punto_vendita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuntoVendita;

	@Column(name = "nome_punto_vendita")
	private String nomePuntoVendita;

	@Column(name = "citta")
	private String citta;

	@Column(name = "regione")
	private String regione;
	
    @Column(name = "id_identifier")
    private String idIdentifier;
   
	@ManyToOne
	@JoinColumn(name = "azienda_id")
	@JsonBackReference
	private Azienda azienda;
	
	@OneToMany(mappedBy = "puntoVendita") // variabile in FedelityCard che è la FOREIGN KEY su id punto vendita
    private List<FedelityCard> carteFedelta;
	
	@ManyToOne
	@JoinColumn(name = "tipologia_azienda_id")
	private TipologiaAzienda tipoAzienda;

	// example builder
	public void exampleBuilder() {
		PuntoVendita p = PuntoVendita.builder()
				.citta(null)
				.tipoAzienda(null)
				.build();
	}

}

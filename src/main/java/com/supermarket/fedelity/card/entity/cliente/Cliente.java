package com.supermarket.fedelity.card.entity.cliente;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

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
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

	@Id	
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "numero_di_telefono")
	private String numeroTelefono;

	@Column(name = "email")
	private String email;

	@Column(name = "data_tesseramento")
	private OffsetDateTime dataTesseramento;

	@Column(name = "numero_tessera")
	private String numeroTessera;

	@Column(name = "storici_acquisti")
	private String storiciAcquisti;
	
    @ManyToOne
    @JoinColumn(name = "carta_fedelta_id")
	@JsonBackReference
    private FedelityCard cartaFedelta;
    
    @OneToMany
    @JoinColumn(name = "acquisti_id")
    private List<Acquisto> acquisti;
    
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id")
    private TipologiaCliente tipoCliente;
    
    @PrePersist
    private void setDateCreate() {
    	dataTesseramento = OffsetDateTime.now();
    }

}

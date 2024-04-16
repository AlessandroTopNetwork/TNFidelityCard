package com.supermarket.fedelity.card.entity.azienda;

import java.time.OffsetDateTime;
import java.util.List;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;
import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "azienda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Azienda {
	
    @Id
	@Column(name = "id_azienda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAzienda;

    @Column(name = "nome")
    private String nomeAzienda;

    @Column(name = "Regione")
    private String regione;

    @Column(name = "citta")
    private String citta;
    
	@Column(name = "data_di_creazione")
	private OffsetDateTime dataCreazione;
    
    @Column(name = "id_identifier")
    private String idIdentifier;

    @OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL) // to test
    private List<PuntoVendita> puntiVendita;
    
    @OneToMany(mappedBy = "azienda", cascade = CascadeType.REMOVE) // da ritestare ma sembra funzionare
    private List<FedelityCard> fedelityCards;
    
    @PrePersist
    private void setDateCreate() {
    	dataCreazione = OffsetDateTime.now();
    }

}

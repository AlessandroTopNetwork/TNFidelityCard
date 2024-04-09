package com.supermarket.fedelity.card.entity.azienda;

import java.util.List;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

import jakarta.persistence.Column;
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
    
    @Column(name = "citta2")
    private String citta2;

    @OneToMany
    @JoinColumn(name = "punto_vendita_id")
    private List<PuntoVendita> puntiVendita;
    
    @ManyToOne
    @JoinColumn(name = "tipo_azienda_id")
    private TipologiaAzienda tipoCliente; // todo verso punto vendita
    
    public void exampleBuilder() {
    	Azienda a = Azienda.builder()
    			.citta(null)
    			.tipoCliente(null)
    			.citta2(null)
    			.build();
    }

}

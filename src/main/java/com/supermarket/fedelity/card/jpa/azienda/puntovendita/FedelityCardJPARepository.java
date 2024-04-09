package com.supermarket.fedelity.card.jpa.azienda.puntovendita;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

public interface FedelityCardJPARepository extends JpaRepository<FedelityCard, Long>{
	
	FedelityCard findByNumeroTessera(String numeroTessera);

}

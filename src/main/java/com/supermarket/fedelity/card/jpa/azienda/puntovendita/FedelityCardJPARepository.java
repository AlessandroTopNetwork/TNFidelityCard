package com.supermarket.fedelity.card.jpa.azienda.puntovendita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.FedelityCard;

public interface FedelityCardJPARepository extends JpaRepository<FedelityCard, Long>{
	
	FedelityCard findByNumeroTessera(String numeroTessera);
	
	@Query(nativeQuery = true, value = "SELECT numero_tessera from carta_fedelta")
	List<String> getAllIdIdentifier();

}

package com.supermarket.fedelity.card.jpa.azienda.puntovendita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

public interface PuntoVenditaJPARepository extends JpaRepository<PuntoVendita, Long>{
	
	PuntoVendita findById(long id);
	
	List<PuntoVendita> findAll();
	
	PuntoVendita findByIdIdentifier(String id);
	
	@Query(nativeQuery = true, value = "SELECT id_identifier from punto_vendita")
	List<String> getAllIdIdentifier();
	
	

}

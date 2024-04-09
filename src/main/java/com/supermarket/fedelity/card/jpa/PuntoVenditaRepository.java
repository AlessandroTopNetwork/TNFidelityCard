package com.supermarket.fedelity.card.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

public interface PuntoVenditaRepository extends JpaRepository<PuntoVendita, Long>{
	
	PuntoVendita findById(long id);
	
	List<PuntoVendita> findAll();
	
	

}

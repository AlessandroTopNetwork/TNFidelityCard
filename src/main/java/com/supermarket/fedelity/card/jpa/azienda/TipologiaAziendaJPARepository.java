package com.supermarket.fedelity.card.jpa.azienda;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;

public interface TipologiaAziendaJPARepository extends JpaRepository<TipologiaAzienda, Long> {
	
	TipologiaAzienda findByTipoAzienda(String tipoAzienda);

}

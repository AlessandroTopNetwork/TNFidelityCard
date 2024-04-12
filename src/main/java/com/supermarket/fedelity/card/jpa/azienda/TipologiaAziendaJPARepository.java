package com.supermarket.fedelity.card.jpa.azienda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.fedelity.card.entity.azienda.TipologiaAzienda;

@Repository
public interface TipologiaAziendaJPARepository extends JpaRepository<TipologiaAzienda, Long> {
	
	TipologiaAzienda findByTipoAzienda(String tipoAzienda);

}

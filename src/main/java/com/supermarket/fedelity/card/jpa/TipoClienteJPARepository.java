package com.supermarket.fedelity.card.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.fedelity.card.entity.cliente.TipologiaCliente;

public interface TipoClienteJPARepository extends JpaRepository<TipologiaCliente, Long>{

	Optional<TipologiaCliente> findByTipoCliente(String tipoCliente);
	
}

package com.supermarket.fedelity.card.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.fedelity.card.entity.TipoCliente;

public interface TipoClienteJPARepository extends JpaRepository<TipoCliente, Long>{

	Optional<TipoCliente> findByTipoCliente(String tipoCliente);
	
}

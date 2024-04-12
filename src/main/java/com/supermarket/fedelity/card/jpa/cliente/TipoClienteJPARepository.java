package com.supermarket.fedelity.card.jpa.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.fedelity.card.entity.cliente.TipologiaCliente;

@Repository
public interface TipoClienteJPARepository extends JpaRepository<TipologiaCliente, Long>{

	Optional<TipologiaCliente> findByTipoCliente(String tipoCliente);
	
}

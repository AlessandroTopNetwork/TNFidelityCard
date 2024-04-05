package com.supermarket.fedelity.card.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.fedelity.card.entity.Cliente;

@Repository
public interface ClienteJPARepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findAll();
	
	List<Cliente> findByCartaFedeltaNumeroTessera(String numeroTessera);
	
	Cliente findById(long id);

}

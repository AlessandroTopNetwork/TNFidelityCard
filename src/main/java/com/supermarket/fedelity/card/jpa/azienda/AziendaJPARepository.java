package com.supermarket.fedelity.card.jpa.azienda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarket.fedelity.card.entity.azienda.Azienda;

@Repository
public interface AziendaJPARepository extends JpaRepository<Azienda, Long>{
	
	Azienda findByIdIdentifier(String idIdentifier);
	
	@Query(nativeQuery = true, value = "SELECT id_identifier from azienda")
	List<String> getAllIdIdentifier();

}

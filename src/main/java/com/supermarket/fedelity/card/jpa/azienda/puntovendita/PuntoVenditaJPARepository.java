package com.supermarket.fedelity.card.jpa.azienda.puntovendita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarket.fedelity.card.entity.azienda.puntovendita.PuntoVendita;

@Repository
public interface PuntoVenditaJPARepository extends JpaRepository<PuntoVendita, Long>{
	
	PuntoVendita findById(long id);
	
	List<PuntoVendita> findAll();
	
	PuntoVendita findByIdIdentifier(String idIdentifier);
	
	@Query(nativeQuery = true, value = "SELECT id_identifier from punto_vendita")
	List<String> getAllIdIdentifier();
	
	@Query(nativeQuery = true, value = "SELECT p.id_punto_vendita,"
			+ " p.nome_punto_vendita, p.citta, p.regione, p.data_di_creazione,"
			+ " p.id_identifier, p.azienda_id, p.tipologia_azienda_id FROM punto_vendita as p"
			+ " INNER JOIN azienda as a ON a.id_azienda = p.azienda_id"
			+ " where a.id_azienda = :idAzienda ; ")
	List<PuntoVendita> findByAziendaIdIdentifier(long idAzienda);

}

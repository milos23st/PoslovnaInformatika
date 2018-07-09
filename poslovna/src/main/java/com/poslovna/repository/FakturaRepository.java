package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.IzlaznaFaktura;
import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;


@Repository
public interface FakturaRepository extends JpaRepository<IzlaznaFaktura, Long> {
	
	List<IzlaznaFaktura> findByPoslovniPartner(PoslovniPartner poslovniPartner);

	List<IzlaznaFaktura> findByPoslovnaGodina(PoslovnaGodina poslovnaGodina);
	
	

}

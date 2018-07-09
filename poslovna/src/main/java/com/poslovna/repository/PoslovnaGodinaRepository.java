package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.Preduzece;

@Repository
public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {
	
	List<PoslovnaGodina> findByPreduzece(Preduzece preduzece);

}

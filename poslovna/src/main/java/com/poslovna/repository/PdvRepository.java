package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.PDV;

@Repository
public interface PdvRepository extends JpaRepository<PDV, Long> {
	
}

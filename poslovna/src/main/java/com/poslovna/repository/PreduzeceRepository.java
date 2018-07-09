package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.Preduzece;
@Repository
public interface PreduzeceRepository extends JpaRepository<Preduzece, Long>{
	
	List<Preduzece> findByNazivPreduzeca(String place);

}

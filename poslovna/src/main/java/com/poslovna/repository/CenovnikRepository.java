package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovna.domain.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik,Long>{
	List<Cenovnik> findByDatumVazenjaGreaterThan(long datumVazenja);

}

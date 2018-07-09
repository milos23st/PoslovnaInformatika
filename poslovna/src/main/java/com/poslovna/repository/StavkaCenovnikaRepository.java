package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.Proizvod;
import com.poslovna.domain.StavkaCenovnika;


@Repository
public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika,Long> {

	List<StavkaCenovnika> findByCenovnikAndProizvod(Cenovnik cenovnik, Proizvod proizvod);

	List<StavkaCenovnika> findByCenovnik(Cenovnik c);
}

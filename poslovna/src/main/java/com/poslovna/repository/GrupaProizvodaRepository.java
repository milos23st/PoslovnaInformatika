package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.GrupaProizvoda;

@Repository
public interface GrupaProizvodaRepository extends JpaRepository<GrupaProizvoda, Long> {

}

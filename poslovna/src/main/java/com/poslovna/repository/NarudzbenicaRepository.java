package com.poslovna.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.Narudzbenica;
@Repository
public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica,Long>{

}

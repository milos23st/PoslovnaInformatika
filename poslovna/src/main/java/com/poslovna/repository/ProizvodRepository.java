package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.Proizvod;
@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long>{

}

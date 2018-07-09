package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.JedinicaMere;

@Repository
public interface JedinicaMereRepository extends JpaRepository<JedinicaMere, Long>{

}

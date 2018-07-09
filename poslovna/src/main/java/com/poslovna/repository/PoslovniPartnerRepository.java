package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.domain.PoslovniPartner;
@Repository
public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner,Long>{

}

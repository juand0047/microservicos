package com.loginms.loginms.repository;

import com.loginms.loginms.entity.AccesoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoRepository extends JpaRepository<AccesoEntity, Long> {
}

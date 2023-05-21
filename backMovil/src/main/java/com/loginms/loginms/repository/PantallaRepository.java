package com.loginms.loginms.repository;

import com.loginms.loginms.entity.PantallaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantallaRepository extends JpaRepository<PantallaEntity, Long> {
}

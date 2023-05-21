package com.loginms.loginms.repository;

import com.loginms.loginms.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<TipoEntity, Long> {
}

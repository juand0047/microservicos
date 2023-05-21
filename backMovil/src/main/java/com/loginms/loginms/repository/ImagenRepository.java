package com.loginms.loginms.repository;

import com.loginms.loginms.entity.ImagenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {
}

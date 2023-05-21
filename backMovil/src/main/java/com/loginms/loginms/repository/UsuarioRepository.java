package com.loginms.loginms.repository;

import com.loginms.loginms.dto.LoginConsultDTO;
import com.loginms.loginms.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByUsuario(String usuario);

    @Query(value = """
            SELECT
            U.USUARIO AS use,
            U.CONTRASEÑA AS password
            FROM USUARIO U
            WHERE U.USUARIO = :usuario
            """,nativeQuery = true)
    LoginConsultDTO loginIn(@Param("usuario") String usuario);

}

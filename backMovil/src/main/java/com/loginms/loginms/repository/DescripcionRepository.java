package com.loginms.loginms.repository;

import com.loginms.loginms.dto.DescripcionOutDTO;
import com.loginms.loginms.entity.DescripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface DescripcionRepository extends JpaRepository<DescripcionEntity, Long> {
    @Query(value = """
            SELECT
            	D.ID_DESCRIPCION AS ID,
            	D.DESCRIPCION AS DESCRIP
            FROM
            	DESCRIPCION D
            WHERE
            	D.TIPO = (
            	SELECT
            		T.ID_TIPO
            	FROM
            		TIPO T
            	WHERE
            		T.TIPO = 'GASTO')
            """, nativeQuery = true)
    List<DescripcionOutDTO> getDescripGasto() throws NullPointerException;

    @Query(value = """
            SELECT
            	D.ID_DESCRIPCION AS ID,
            	D.DESCRIPCION AS DESCRIP
            FROM
            	DESCRIPCION D
            WHERE
            	D.TIPO = (
            	SELECT
            		T.ID_TIPO
            	FROM
            		TIPO T
            	WHERE
            		T.TIPO = 'INGRESO')
            """, nativeQuery = true)
    List<DescripcionOutDTO> getDescripIngreso() throws NullPointerException;

}

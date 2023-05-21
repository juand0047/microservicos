package com.dinny.operationsdinny.repository;

import com.dinny.operationsdinny.dto.ContabilidadConsultDTO;
import com.dinny.operationsdinny.dto.ContabilidadModalOutDTO;
import com.dinny.operationsdinny.entity.ContabilidadEntity;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ContabilidadRepository extends JpaRepository<ContabilidadEntity, Long> {

    @Query(value = """
            SELECT SUM(VALOR) AS TOTAL FROM CONTABILIDAD C
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            WHERE U.USUARIO = :usuario
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'GASTO')
            """, nativeQuery = true)
    Long gastosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT SUM(VALOR) AS TOTAL FROM CONTABILIDAD C
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            WHERE U.USUARIO = :usuario
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'INGRESO')
                    """, nativeQuery = true)
    Long ingresosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT
            C.ID_CONTABILIDAD,
            C.FECHA,
            C.TIPO,
            C.VALOR,	
            C.ID_CATEGORIA,
            C.ID_DESCRIPCION,
            C.ID_USUARIO
            FROM CONTABILIDAD C
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            INNER JOIN CATEGORIA CA ON CA.ID_CATEGORIA = C.ID_CATEGORIA
            INNER JOIN DESCRIPCION D ON D.ID_DESCRIPCION = C.ID_DESCRIPCION
            WHERE UPPER(U.USUARIO) = UPPER(:usuario)
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'GASTO')
            """, nativeQuery = true)
    List<ContabilidadEntity> listGastosByusuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT
            C.ID_CONTABILIDAD,
            C.FECHA,
            C.TIPO,
            C.VALOR,	
            C.ID_CATEGORIA,
            C.ID_DESCRIPCION,
            C.ID_USUARIO
            FROM CONTABILIDAD C
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            INNER JOIN CATEGORIA CA ON CA.ID_CATEGORIA = C.ID_CATEGORIA
            INNER JOIN DESCRIPCION D ON D.ID_DESCRIPCION = C.ID_DESCRIPCION
            WHERE UPPER(U.USUARIO) = UPPER(:usuario)
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'INGRESO')
            """, nativeQuery = true)
    List<ContabilidadEntity> listIngresosByusuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT
            	C.ID_CONTABILIDAD AS idCont,
            	C.VALOR AS valor,
            	C.FECHA AS fecha,
            	CA.CATEGORIA AS cate,
            	D.DESCRIPCION AS descrip,
            	U.USUARIO AS usuario
            FROM
            	CONTABILIDAD C
            INNER JOIN CATEGORIA CA ON
            	CA.ID_CATEGORIA = C.ID_CATEGORIA
            INNER JOIN DESCRIPCION D ON
            	D.ID_DESCRIPCION = C.ID_DESCRIPCION
            INNER JOIN USUARIO U ON
            	U.ID_USUARIO = C.ID_USUARIO
            WHERE
            	C.ID_CONTABILIDAD = :idContabilidad
            """, nativeQuery = true)
    ContabilidadModalOutDTO getContabilidad(@Param("idContabilidad") Long idContabilidad) throws SQLException, NumberFormatException;

    @Query(value = """
               SELECT
               C.TIPO AS TIPO,
               C.FECHA AS FECHA,
               D.DESCRIPCION AS DESCRIPCION,
               C.VALOR AS VALOR,
               CA.CATEGORIA AS CATEGORIA
               FROM CONTABILIDAD C
               INNER JOIN USUARIO U ON
               	U.ID_USUARIO = C.ID_USUARIO
               INNER JOIN CATEGORIA CA ON
               	CA.ID_CATEGORIA = C.ID_CATEGORIA
               INNER JOIN DESCRIPCION D ON
                D.ID_DESCRIPCION = C.ID_DESCRIPCION
                WHERE U.USUARIO = :usuario
                AND
                C.FECHA >= :fechaI
                AND
                C.FECHA <= :fechaF
                AND
                C.TIPO IN (:tipo)
                """, nativeQuery = true)
    List<Map<String, ContabilidadConsultDTO>> listContabilidad(
            @Param("usuario") String usuario,
            @Param("fechaI") Date fechaI,
            @Param("fechaF") Date fechaF,
            @Param("tipo") List<Long> tipo);

    @Query(value = """
               SELECT
               C.TIPO AS TIPO,
               C.FECHA AS FECHA,
               D.DESCRIPCION AS DESCRIPCION,
               C.VALOR AS VALOR,
               CA.CATEGORIA AS CATEGORIA
               FROM CONTABILIDAD C
               INNER JOIN USUARIO U ON
               	U.ID_USUARIO = C.ID_USUARIO
               INNER JOIN CATEGORIA CA ON
               	CA.ID_CATEGORIA = C.ID_CATEGORIA
               INNER JOIN DESCRIPCION D ON
                D.ID_DESCRIPCION = C.ID_DESCRIPCION
                WHERE U.USUARIO = :usuario
                AND
                C.FECHA >= :fechaI
                AND
                C.FECHA <= :fechaF
                AND
                C.TIPO IN (:tipo)
                """, nativeQuery = true)
    List<ContabilidadConsultDTO> listContabilidad2(
            @Param("usuario") String usuario,
            @Param("fechaI") Date fechaI,
            @Param("fechaF") Date fechaF,
            @Param("tipo") List<Long> tipo);

    @Query(value = """
            SELECT SUM(VALOR)
            FROM CONTABILIDAD
            WHERE TIPO = 2
            AND
            ID_CATEGORIA = :idCategoria
            """, nativeQuery = true)
    Long totalGastoByCategoria(@Param("idCategoria") Long idCategoria);

}

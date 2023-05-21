package com.dinny.operationsdinny.service;

import com.dinny.operationsdinny.dto.ContabilidadDTO;
import com.dinny.operationsdinny.dto.ContabilidadModalOutDTO;

import java.sql.SQLException;

public interface IContabillidadService {

    /**
     * Guardar un nuevo registro contable
     *
     * @param contabilidadDTO Dto de entrada
     * @throws NullPointerException
     */
    void guardarContabillidad(ContabilidadDTO contabilidadDTO) throws NullPointerException;

    /**
     * Eliminar un registro contable
     *
     * @param idContabilidad Id del registro a eliminar
     * @throws NullPointerException
     */
    void eliminarContabillidad(Long idContabilidad) throws NullPointerException;

    /**
     * Actualizar un registro contable
     *
     * @param idContabilidad  Id del registro a actualizar
     * @param contabilidadDTO Datos a actualizar
     * @throws NullPointerException
     */
    void actualizarContabillidad(Long idContabilidad, ContabilidadDTO contabilidadDTO) throws NullPointerException;

    /**
     * Ver registro contable
     *
     * @param idContabilidad Id del registro
     * @throws NullPointerException Error
     * @throws SQLException         Error
     */
    ContabilidadModalOutDTO getRegistroCont(Long idContabilidad) throws NullPointerException, SQLException;

    /**
     * totalGastoByCategoria
     *
     * @param idCategoria Id de la categoria
     * @return Long
     */
    Long totalGastoByCategoria(Long idCategoria);

}

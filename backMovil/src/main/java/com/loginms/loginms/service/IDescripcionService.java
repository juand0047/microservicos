package com.loginms.loginms.service;

import com.loginms.loginms.dto.DescripcionDTO;
import com.loginms.loginms.dto.DescripcionOutDTO;

import java.util.List;

public interface IDescripcionService {
    /**
     * Crea una descripcion
     *
     * @param descripcionDTO Parametros de entrada
     * @throws NullPointerException Error
     */
    void guardarDescripcion(DescripcionDTO descripcionDTO) throws NullPointerException;

    /**
     * Elimina una descripcion
     *
     * @param id Id de la descripcion
     * @throws NullPointerException Error
     */
    void eliminarDescripcion(Long id) throws NullPointerException;

    /**
     * Descripciones de gastos
     * @return
     * @throws NullPointerException
     */
    List<DescripcionOutDTO> getDescripGasto() throws NullPointerException;

    /**
     * Descripciones de ingresos
     * @return
     * @throws NullPointerException
     */
    List<DescripcionOutDTO> getDescripIngreso() throws NullPointerException;

}

package com.loginms.loginms.service;

public interface ITipoService {

    /**
     * Valida si exite un tipo INGRESO o GASTO
     *
     * @param id parametro de entrada
     * @return Boolean
     * @throws NullPointerException Error
     */
    Boolean validarTipo(Long id) throws NullPointerException;
}

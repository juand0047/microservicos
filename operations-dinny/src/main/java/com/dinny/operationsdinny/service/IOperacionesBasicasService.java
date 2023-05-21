package com.dinny.operationsdinny.service;

import com.dinny.operationsdinny.dto.ContaOutDTO;
import com.dinny.operationsdinny.dto.ContabilidadOutDTO;

import java.util.List;

public interface IOperacionesBasicasService {

    /**
     * Obtener el valor total de gastos de el usuario
     *
     * @param usuario Usuario a consultar
     * @return total de gastos
     * @throws NullPointerException Error
     */
    Long gastosDeUsuario(String usuario) throws NullPointerException;

    /**
     * Obtener el valor total de los ingresos de el usuario
     * @param usuario Usuario a consultar
     * @return total de los ingresos
     * @throws NullPointerException Error
     */
    Long ingresosDeUsuario(String usuario) throws NullPointerException;

    /**
     * Lista de los gastos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los gastos
     * @throws NullPointerException
     */
    List<ContabilidadOutDTO> listGastosByusuario(String usuario) throws NullPointerException;
    /**
     * Lista de los ingresos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los ingresos
     * @throws NullPointerException
     */
    List<ContabilidadOutDTO> listIngresosByusuario(String usuario) throws NullPointerException;

    /**
     * Lista de gastos paginados
     * @param usuario Usuario
     * @param pagActual Pagina actual
     * @param cantDatos Cantidad de datos por pagina
     * @return Lista
     * @throws NullPointerException Error
     */
    ContaOutDTO paginadoGastos(
            String usuario, Long pagActual, Long cantDatos) throws NullPointerException;

    /**
     * Lista de ingresos paginados
     * @param usuario Usuario
     * @param pagActual Pagina actual
     * @param cantDatos Cantidad de datos por pagina
     * @return Lista
     * @throws NullPointerException Error
     */
    ContaOutDTO paginadoIngresos(
            String usuario, Long pagActual, Long cantDatos) throws NullPointerException;

    /**
     * Total disponible del usuario
     * @return
     * @throws NullPointerException
     */
    Long disponible(String usuario) throws NullPointerException;

}

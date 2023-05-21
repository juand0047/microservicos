package com.loginms.loginms.service;

import com.loginms.loginms.dto.CategoriaDTO;

public interface ICategoriaService {

    /**
     * Guardar una categoria
     * @param categoriaDTO Parametro de entrada
     * @throws NullPointerException Error
     */
    void guardarCategoria(CategoriaDTO categoriaDTO) throws NullPointerException;

    /**
     * Eliminar una categoria
     * @param idCategoria Id de la categoria a eliminar
     * @throws NullPointerException Error
     */
    void eliminarCategoria(Long idCategoria) throws NullPointerException;

}

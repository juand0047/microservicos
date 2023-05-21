package com.loginms.loginms.service;

import com.loginms.loginms.dto.UsuarioDTO;
import com.loginms.loginms.entity.UsuarioEntity;

public interface IUsuarioService {
    /**
     * Crear un usuario
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    void nuevoUsuario(UsuarioDTO usuario) throws NullPointerException;

    /**
     * Buscar un usuario por su usuario
     *
     * @param usuario Parametro de entrada
     * @return UsuarioEntity
     * @throws NullPointerException Error
     */
    UsuarioEntity usuarioByUsuario(String usuario) throws NullPointerException;

    /**
     * Validar si un usuario existe por su usuario
     *
     * @param usuario Parametro de entrada
     * @return Boolean
     * @throws NullPointerException Error
     */
    Boolean validarUserExist(String usuario) throws NullPointerException;

    /**
     * Actualizar el rol de un usuario a VIP
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    void actualizarUsuario(String usuario) throws NullPointerException;

    /**
     * Borrar un usuario
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    void borrarUsuario(String usuario) throws NullPointerException;

}

package com.loginms.loginms.controller;

import com.loginms.loginms.dto.UsuarioDTO;
import com.loginms.loginms.entity.UsuarioEntity;
import com.loginms.loginms.service.IUsuarioService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_USUARIO)
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    /**
     * Crear un usuario
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    @PostMapping
    public void nuevoUsuario(@RequestBody UsuarioDTO usuario) throws NullPointerException {
        usuarioService.nuevoUsuario(usuario);
    }

    /**
     * Buscar un usuario por su usuario
     *
     * @param usuario Parametro de entrada
     * @return UsuarioEntity
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_USUARIO_USER)
    public UsuarioEntity usuarioByUsuario(@PathVariable("usuario") String usuario) throws NullPointerException {
        return usuarioService.usuarioByUsuario(usuario);
    }

    /**
     * Actualizar el rol de un usuario a VIP
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    @PutMapping(value = Constantes.Urls.PATH_USUARIO_USER)
    void actualizarUsuario(@PathVariable("usuario") String usuario) throws NullPointerException {
        usuarioService.actualizarUsuario(usuario);
    }

    /**
     * Borrar un usuario
     *
     * @param usuario Parametro de entrada
     * @throws NullPointerException Error
     */
    @DeleteMapping(value = Constantes.Urls.PATH_USUARIO_USER)
    public void borrarUsuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        usuarioService.borrarUsuario(usuario);
    }

}

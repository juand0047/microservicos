package com.loginms.loginms.controller;

import com.loginms.loginms.dto.CategoriaDTO;
import com.loginms.loginms.service.ICategoriaService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_CATEGORIA)
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    /**
     * Guardar una categoria
     *
     * @param categoriaDTO Parametro de entrada
     * @throws NullPointerException Error
     */
    @PostMapping
    public void guardarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws NullPointerException {
        categoriaService.guardarCategoria(categoriaDTO);
    }

    /**
     * Eliminar una categoria
     *
     * @param idCategoria Id de la categoria a eliminar
     * @throws NullPointerException Error
     */
    @DeleteMapping(value = Constantes.Urls.PATH_CATEGORIA_ID)
    public void eliminarCategoria(@PathVariable("idCategoria") Long idCategoria) throws NullPointerException {
        categoriaService.eliminarCategoria(idCategoria);
    }

}

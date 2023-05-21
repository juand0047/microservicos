package com.loginms.loginms.controller;

import com.loginms.loginms.dto.DescripcionDTO;
import com.loginms.loginms.dto.DescripcionOutDTO;
import com.loginms.loginms.service.IDescripcionService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_DESCRIP)
public class DescripcionController {

    @Autowired
    private IDescripcionService descripcionService;

    /**
     * Crea una descripcion
     *
     * @param descripcionDTO Parametros de entrada
     * @throws NullPointerException Error
     */
    @PostMapping
    public void guardarDescripcion(@RequestBody DescripcionDTO descripcionDTO) throws NullPointerException {
        descripcionService.guardarDescripcion(descripcionDTO);
    }

    /**
     * Elimina una descripcion
     *
     * @param id Id de la descripcion
     * @throws NullPointerException Error
     */
    @DeleteMapping(path = Constantes.Urls.PATH_DESCRIP_ID)
    public void eliminarDescripcion(@PathVariable("id") Long id) throws NullPointerException {
        descripcionService.eliminarDescripcion(id);
    }

    /**
     * Descripciones de gastos
     * @return
     * @throws NullPointerException
     */
    @GetMapping(path = Constantes.Urls.PATH_DESCRIP_GASTO)
    public List<DescripcionOutDTO> getDescripGasto() throws NullPointerException{
        return descripcionService.getDescripGasto();
    }

    /**
     * Descripciones de ingresos
     * @return
     * @throws NullPointerException
     */
    @GetMapping(path = Constantes.Urls.PATH_DESCRIP_INGRESO)
    public List<DescripcionOutDTO> getDescripIngreso() throws NullPointerException{
        return descripcionService.getDescripIngreso();
    }

}

package com.dinny.operationsdinny.controller;

import com.dinny.operationsdinny.dto.ContabilidadDTO;
import com.dinny.operationsdinny.dto.ContabilidadModalOutDTO;
import com.dinny.operationsdinny.service.IContabillidadService;
import com.dinny.operationsdinny.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_CONTABILIDAD)
public class ContabillidadController {

    @Autowired
    private IContabillidadService contabillidadService;

    /**
     * Guardar un nuevo registro contable
     * @param contabilidadDTO Dto de entrada
     * @throws NullPointerException
     */
    @PostMapping
    public void guardarContabillidad(@RequestBody ContabilidadDTO contabilidadDTO) throws NullPointerException{
        contabillidadService.guardarContabillidad(contabilidadDTO);
    }

    /**
     * Eliminar un registro contable
     * @param idContabilidad Id del registro a eliminar
     * @throws NullPointerException
     */
    @DeleteMapping(path = Constantes.Urls.PATH_CONTABILIDAD_ID)
    public void eliminarContabillidad(@PathVariable("idContabilidad") Long idContabilidad) throws NullPointerException{
        contabillidadService.eliminarContabillidad(idContabilidad);
    }

    /**
     * Actualizar un registro contable
     * @param idContabilidad Id del registro a actualizar
     * @param contabilidadDTO Datos a actualizar
     * @throws NullPointerException
     */
    @PutMapping(path = Constantes.Urls.PATH_CONTABILIDAD_ID)
    public void actualizarContabillidad(@PathVariable("idContabilidad") Long idContabilidad,
                                        @RequestBody ContabilidadDTO contabilidadDTO) throws NullPointerException{
        contabillidadService.actualizarContabillidad(idContabilidad, contabilidadDTO);
    }

    /**
     * Ver registro contable
     *
     * @param idContabilidad Id del registro
     * @throws NullPointerException Error
     * @throws SQLException Error
     */
    @GetMapping(path = Constantes.Urls.PATH_CONTABILIDAD_ID)
    public ContabilidadModalOutDTO getRegistroCont(
            @PathVariable("idContabilidad") String idContabilidad) throws NullPointerException, SQLException{
        return contabillidadService.getRegistroCont(Long.valueOf(idContabilidad));
    }

    /**
     * totalGastoByCategoria
     * @param idCategoria Id de la categoria
     * @return Long
     */
    @GetMapping(path = Constantes.Urls.PATH_CATEGORIA_ID_CATE)
    public Long totalGastoByCategoria(@PathVariable("idCategoria") Long idCategoria){
        return contabillidadService.totalGastoByCategoria(idCategoria);
    }

}

package com.dinny.operationsdinny.controller;


import com.dinny.operationsdinny.dto.ContaOutDTO;
import com.dinny.operationsdinny.service.IOperacionesBasicasService;
import com.dinny.operationsdinny.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_OPER_BASICAS)
public class OperacionesBasicasController {

    @Autowired
    private IOperacionesBasicasService operacionesBasicasService;

    /**
     * Obtener el valor total de gastos de el usuario
     *
     * @param usuario Usuario a consultar
     * @return total de los gastos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_GAST)
    public Long gastosDeUsuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.gastosDeUsuario(usuario);
    }

    /**
     * Obtener el valor total de los ingresos de el usuario
     * @param usuario Usuario a consultar
     * @return total de los ingresos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_INGRE)
    public Long ingresosDeUsuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.ingresosDeUsuario(usuario);
    }

    /**
     * Lista de los gastos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los gastos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_GASTS)
    public ContaOutDTO listGastosByusuario(
            @PathVariable("usuario") String usuario,
            @PathVariable("pag") Long pagina,
            @PathVariable("cant") Long cantidad) throws NullPointerException{
        return operacionesBasicasService.paginadoGastos(usuario, pagina, cantidad);
    }

    /**
     * Lista de los ingresos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los ingresos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_INGRES)
    public ContaOutDTO listIngresosByusuario(
            @PathVariable("usuario") String usuario,
            @PathVariable("pag") Long pagina,
            @PathVariable("cant") Long cantidad) throws NullPointerException{
        return operacionesBasicasService.paginadoIngresos(usuario, pagina, cantidad);
    }

    /**
     * Total disponible del usuario
     * @return Long
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_DISPO_USUARIO)
    public Long disponible(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.disponible(usuario);
    }

}

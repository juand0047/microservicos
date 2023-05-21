package com.dinny.operationsdinny.service.implementation;

import com.dinny.operationsdinny.dto.ContaOutDTO;
import com.dinny.operationsdinny.dto.ContabilidadOutDTO;
import com.dinny.operationsdinny.entity.ContabilidadEntity;
import com.dinny.operationsdinny.repository.ContabilidadRepository;
import com.dinny.operationsdinny.service.IOperacionesBasicasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperacionesBasicasService implements IOperacionesBasicasService {

    private final ContabilidadRepository contabilidadRepository;

    @Override
    public Long gastosDeUsuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }
        Long gastos = contabilidadRepository.gastosDeUsuario(usuario);
        if (gastos == null) {
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }
        return gastos;
    }

    @Override
    public Long ingresosDeUsuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }
        Long ingresos = contabilidadRepository.ingresosDeUsuario(usuario);
        if (ingresos == null) {
            throw new NullPointerException("El usuario no tiene ingresos registrado");
        }
        return ingresos;
    }

    @Override
    public List<ContabilidadOutDTO> listGastosByusuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }

        List<ContabilidadEntity> listGastos = contabilidadRepository.listGastosByusuario(usuario);
        if (listGastos.isEmpty()) {
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }

        List<ContabilidadOutDTO> listGastosDTO = new ArrayList<>();
        for (ContabilidadEntity entity : listGastos) {
            listGastosDTO.add(new ContabilidadOutDTO(entity));
        }

        return listGastosDTO;
    }

    @Override
    public List<ContabilidadOutDTO> listIngresosByusuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }

        List<ContabilidadEntity> listIngresos = contabilidadRepository.listIngresosByusuario(usuario);
        if (listIngresos.isEmpty()) {
            throw new NullPointerException("El usuario no tiene ingresos registrado");
        }

        List<ContabilidadOutDTO> listIngresosDTO = new ArrayList<>();
        for (ContabilidadEntity entity : listIngresos) {
            listIngresosDTO.add(new ContabilidadOutDTO(entity));
        }

        return listIngresosDTO;
    }

    @Override
    public ContaOutDTO paginadoGastos(String usuario, Long pagActual, Long cantDatos) throws NullPointerException {
        List<ContabilidadOutDTO> datos = listGastosByusuario(usuario); // Obtén tu lista de datos
        ContaOutDTO result = paginar(datos, pagActual, cantDatos);
        return result;
    }

    @Override
    public ContaOutDTO paginadoIngresos(String usuario, Long pagActual, Long cantDatos) throws NullPointerException {
        List<ContabilidadOutDTO> datos = listIngresosByusuario(usuario); // Obtén tu lista de datos
        ContaOutDTO result = paginar(datos, pagActual, cantDatos);
        return result;
    }

    @Override
    public Long disponible(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }

        Long gastos = contabilidadRepository.gastosDeUsuario(usuario);
        if (gastos == null) {
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }

        Long ingresos = contabilidadRepository.ingresosDeUsuario(usuario);
        if (ingresos == null) {
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }

        Long disponible = ingresos - gastos;

        return disponible;
    }

    private ContaOutDTO paginar(List<ContabilidadOutDTO> datos, Long paginaActual, Long elementosPorPagina) {
        Long inicio = (paginaActual - 1) * elementosPorPagina;
        Long fin = Math.min(inicio + elementosPorPagina, datos.size());

        var cantPage = Math.ceil((double) datos.size() / elementosPorPagina);

        ContaOutDTO contaOutDTO = new ContaOutDTO();
        contaOutDTO.setTotalPagina((long) cantPage);

        List<ContabilidadOutDTO> result = new ArrayList<>();

        List<ContabilidadOutDTO> elementosPagina = datos.subList(Math.toIntExact(inicio), Math.toIntExact(fin));

        // Mostrar los elementos de la página actual
        for (ContabilidadOutDTO elemento : elementosPagina) {
            result.add(elemento);
        }

        contaOutDTO.setContaOutList(result);

        if (result.isEmpty()) {
            throw new NullPointerException("No hay mas registros por mostrar");
        }

        return contaOutDTO;
    }


}

package com.dinny.operationsdinny.service.implementation;

import com.dinny.operationsdinny.dto.ContabilidadDTO;
import com.dinny.operationsdinny.dto.ContabilidadModalOutDTO;
import com.dinny.operationsdinny.entity.ContabilidadEntity;
import com.dinny.operationsdinny.repository.ContabilidadRepository;
import com.dinny.operationsdinny.service.IContabillidadService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ContabillidadService implements IContabillidadService {

    private final ContabilidadRepository contabilidadRepository;

    @Override
    public void guardarContabillidad(ContabilidadDTO contabilidadDTO) throws NullPointerException {
        if (Objects.isNull(contabilidadDTO)) {
            throw new NullPointerException("Parametro de entrada no puede ser nulo");
        }

        ModelMapper mapper = new ModelMapper();
        ContabilidadEntity contabilidadEntity = mapper.map(contabilidadDTO, ContabilidadEntity.class);
        contabilidadEntity.setFecha(new Date());
        contabilidadEntity.setIdCategoria(contabilidadDTO.getIdCategoria());
        contabilidadEntity.setIdDescripcion(contabilidadDTO.getIdDescripcion());
        contabilidadEntity.setIdUsuario(contabilidadDTO.getIdUsuario());
        contabilidadRepository.save(contabilidadEntity);
    }

    @Override
    public void eliminarContabillidad(Long idContabilidad) throws NullPointerException {
        if (idContabilidad == null || idContabilidad.equals(" ")) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }
        contabilidadRepository.deleteById(idContabilidad);
    }

    @Override
    public void actualizarContabillidad(Long idContabilidad, ContabilidadDTO contabilidadDTO) throws NullPointerException {
        if (idContabilidad == null || idContabilidad.equals(" ") || Objects.isNull(contabilidadDTO)) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }

        ContabilidadEntity entity = contabilidadRepository.findById(idContabilidad).orElse(null);
        if (Objects.isNull(entity)) {
            throw new NullPointerException("El registro contable no existe");
        }

        ModelMapper mapper = new ModelMapper();
        ContabilidadEntity contabilidad = mapper.map(entity, ContabilidadEntity.class);
        contabilidad.setValor(contabilidadDTO.getValor());
        contabilidad.setIdTipo(contabilidadDTO.getIdTipo());
        contabilidad.setFecha(new Date());
        contabilidad.setIdCategoria(contabilidadDTO.getIdCategoria());
        contabilidad.setIdDescripcion(contabilidadDTO.getIdDescripcion());
        contabilidad.setIdUsuario(contabilidadDTO.getIdUsuario());
        contabilidadRepository.save(contabilidad);
    }

    @Override
    public ContabilidadModalOutDTO getRegistroCont(Long idContabilidad) throws NullPointerException, SQLException {

        if (idContabilidad == null) {
            throw new NullPointerException("Parametro de enrada no puede ser nulo.");
        }

        ContabilidadModalOutDTO result = contabilidadRepository.getContabilidad(idContabilidad);

        if (Objects.isNull(result)) {
            throw new NullPointerException("Error al consultar el registro contable");
        }

        return result;

    }

    @Override
    public Long totalGastoByCategoria(Long idCategoria) {

        if (idCategoria == null) {
            throw new NullPointerException("Parametro de enrada no puede ser nulo.");
        }

        Long total = contabilidadRepository.totalGastoByCategoria(idCategoria);

        if (total == null) {
            total = 0L;
        }

        return total;

    }

}

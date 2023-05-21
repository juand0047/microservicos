package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.DescripcionDTO;
import com.loginms.loginms.dto.DescripcionOutDTO;
import com.loginms.loginms.entity.DescripcionEntity;
import com.loginms.loginms.repository.DescripcionRepository;
import com.loginms.loginms.service.IDescripcionService;
import com.loginms.loginms.service.ITipoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DescripcionService implements IDescripcionService {

    private final DescripcionRepository descripcionRepository;
    private final ITipoService tipoService;

    @Override
    public void guardarDescripcion(DescripcionDTO descripcionDTO) throws NullPointerException {

        if (Objects.isNull(descripcionDTO)) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }

        Boolean validarTipo = tipoService.validarTipo(descripcionDTO.getIdTipo());

        if (!validarTipo) {
            throw new NullPointerException("El tipo no existe");
        }

        ModelMapper mapper = new ModelMapper();
        DescripcionEntity descripcionEntity = mapper.map(descripcionDTO, DescripcionEntity.class);
        descripcionRepository.save(descripcionEntity);

    }

    @Override
    public void eliminarDescripcion(Long id) throws NullPointerException {
        if (id == null || id.equals(" ")) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }
        descripcionRepository.deleteById(id);
    }

    @Override
    public List<DescripcionOutDTO> getDescripGasto() throws NullPointerException {
        List<DescripcionOutDTO> result = descripcionRepository.getDescripGasto();

        if (Objects.isNull(result)) {
            throw new NullPointerException("No se han encontradoo descripciones");
        }

        return result;
    }

    @Override
    public List<DescripcionOutDTO> getDescripIngreso() throws NullPointerException {
        List<DescripcionOutDTO> result = descripcionRepository.getDescripIngreso();

        if (Objects.isNull(result)) {
            throw new NullPointerException("No se han encontradoo descripciones");
        }

        return result;
    }
}

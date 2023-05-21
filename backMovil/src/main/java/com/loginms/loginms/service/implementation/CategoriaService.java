package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.CategoriaDTO;
import com.loginms.loginms.entity.CategoriaEntity;
import com.loginms.loginms.entity.ImagenEntity;
import com.loginms.loginms.repository.CategoriaRepository;
import com.loginms.loginms.service.ICategoriaService;
import com.loginms.loginms.service.ITipoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ITipoService tipoService;

    @Override
    public void guardarCategoria(CategoriaDTO categoriaDTO) throws NullPointerException {
        if (Objects.isNull(categoriaDTO)) {
            throw new NullPointerException("El parametro de entrada no puede llegar nulo");
        }

        Boolean validarTipo = tipoService.validarTipo(categoriaDTO.getIdTipo());

        if (!validarTipo) {
            throw new NullPointerException("El tipo no existe");
        }

        ModelMapper mapper = new ModelMapper();
        CategoriaEntity categoria = mapper.map(categoriaDTO, CategoriaEntity.class);
        categoria.setImagen(
                new ImagenEntity(categoriaDTO.getIdImagen())
        );
        System.out.println(categoria);
        categoriaRepository.save(categoria);

    }

    @Override
    public void eliminarCategoria(Long idCategoria) throws NullPointerException {
        if (idCategoria == null) {
            throw new NullPointerException("El parametro de entrada no puede llegar nulo");
        }
        categoriaRepository.deleteById(idCategoria);
    }
}

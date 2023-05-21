package com.loginms.loginms.dto;

import com.loginms.loginms.entity.ContabilidadEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContabilidadOutDTO {

    private Long id_contabilidad;
    private Long idTipo;
    private Long valor;
    private Date fecha;
    private Long IdCategoria;
    private Long idDescripcion;
    private Long idUsuario;

    public ContabilidadOutDTO(ContabilidadEntity entity) {
        this.id_contabilidad = entity.getId_contabilidad();
        this.idTipo = entity.getIdTipo();
        this.valor = entity.getValor();
        this.fecha = entity.getFecha();
        this.IdCategoria = entity.getCategoria().getId_categoria();
        this.idDescripcion = entity.getDescripcion().getId_descripcion();
        this.idUsuario = entity.getUsuarios().getId_usuario();
    }
}

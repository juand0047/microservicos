package com.dinny.operationsdinny.dto;

import com.dinny.operationsdinny.entity.ContabilidadEntity;
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
        this.IdCategoria = entity.getIdCategoria();
        this.idDescripcion = entity.getIdDescripcion();
        this.idUsuario = entity.getIdUsuario();
    }
}

package com.dinny.operationsdinny.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "contabilidad")
public class ContabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contabilidad;
    @Column(name = "tipo")
    private Long idTipo;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "fecha")
    private Date fecha;
    /*@JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")*/
    private Long idCategoria;
    /*@JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_descripcion")*/
    private Long idDescripcion;
    /*@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")*/
    private Long idUsuario;

}

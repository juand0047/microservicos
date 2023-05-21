package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "descripcion")
public class DescripcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_descripcion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private Long idTipo;
    @JsonIgnore
    @OneToOne(mappedBy = "descripcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContabilidadEntity contabilidad;

    public DescripcionEntity(Long id_descripcion) {
        this.id_descripcion = id_descripcion;
    }
}

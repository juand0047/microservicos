package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "id_tipo")
    private Long idTipo;
    @JsonIgnore
    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContabilidadEntity contabilidad;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen")
    private ImagenEntity imagen;

    public CategoriaEntity(Long id_categoria) {
        this.id_categoria = id_categoria;
    }
}

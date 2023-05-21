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
@Table(name = "imagen")
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_imagen;
    @Column(name = "imagen")
    private Byte[] imagen;
    @JsonIgnore
    @OneToOne(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private CategoriaEntity categoria;

    public ImagenEntity(Long id_imagen) {
        this.id_imagen = id_imagen;
    }
}

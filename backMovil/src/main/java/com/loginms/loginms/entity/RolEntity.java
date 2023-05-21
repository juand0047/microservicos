package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    @Column(name = "rols")
    private String rol;
    @JsonIgnore
    @OneToOne(mappedBy = "role")
    private UsuarioEntity usuario;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "acceso",
            joinColumns = {@JoinColumn(name = "id_rol")},
            inverseJoinColumns = {@JoinColumn(name = "id_pantalla")}
    )
    private List<PantallaEntity> pantallas;

    public RolEntity(Long id_rol) {
        this.id_rol = id_rol;
    }
}

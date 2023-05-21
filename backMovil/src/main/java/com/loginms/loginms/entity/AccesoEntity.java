package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "acceso")
public class AccesoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;
    @Column(name = "id_pantalla")
    private Long idPantalla;
    @Column(name = "id_rol")
    private Long idRol;

}

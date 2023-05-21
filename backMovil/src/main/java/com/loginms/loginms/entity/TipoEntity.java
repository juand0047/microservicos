package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tipo")
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo;
    @Column(name = "tipo")
    private String tipo;

}

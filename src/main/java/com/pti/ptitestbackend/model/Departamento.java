package com.pti.ptitestbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "departamentos")
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String iso;

//    @OneToMany
//    private Ciudades ciudades;

}

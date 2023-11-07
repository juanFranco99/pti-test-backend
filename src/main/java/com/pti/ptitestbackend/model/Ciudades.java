package com.pti.ptitestbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}

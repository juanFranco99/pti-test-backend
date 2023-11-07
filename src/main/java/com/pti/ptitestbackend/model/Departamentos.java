package com.pti.ptitestbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String iso;



}

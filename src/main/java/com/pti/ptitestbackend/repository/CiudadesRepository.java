package com.pti.ptitestbackend.repository;

import com.pti.ptitestbackend.model.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {
}

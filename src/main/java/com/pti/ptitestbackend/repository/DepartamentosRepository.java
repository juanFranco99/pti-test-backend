package com.pti.ptitestbackend.repository;

import com.pti.ptitestbackend.model.Departamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Long> {
}

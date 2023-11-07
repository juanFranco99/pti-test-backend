package com.pti.ptitestbackend.service;

import com.pti.ptitestbackend.model.Departamento;
import com.pti.ptitestbackend.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentosService {

    @Autowired
    private DepartamentosRepository repository;

    //Lista todas los departamentos
    public List<Departamento> getAll(){
        return repository.findAll();
    }

    //Obtiene por Id el departamento
    public Departamento getDepartamentosById(Long id){
        Optional<Departamento> Departamentos = repository.findById(id);
        return Departamentos.orElseGet(Departamento::new);
    }

    //Crea un nuevo departamento
    public Departamento addDepartamentos(Departamento Departamentos){
        return repository.save(Departamentos);
    }

    //Actualiza el departamento
    public Departamento updateDepartamentos(Long id, Departamento Departamentos){
        Optional<Departamento> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException(String.format("El Departamento con el id %s no fue encontrado", id));
        }
        Departamentos.setId(id);
        return  repository.save(Departamentos);
    }

    //Elimina por Id
    public void deleteDepartamentos(Long id){
        Optional<Departamento> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException(String.format("El departamento con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }
}

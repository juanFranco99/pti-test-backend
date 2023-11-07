package com.pti.ptitestbackend.service;

import com.pti.ptitestbackend.model.Departamentos;
import com.pti.ptitestbackend.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepertamentosService {

    @Autowired
    private DepartamentosRepository repository;

    //Lista todas los departamentos
    public List<Departamentos> getAll(){
        return repository.findAll();
    }

    //Obtiene por Id el departamento
    public Departamentos getDepartamentosById(Long id){
        Optional<Departamentos> Departamentos = repository.findById(id);
        return Departamentos.orElseGet(Departamentos::new);
    }

    //Crea un nuevo departamento
    public Departamentos addDepartamentos(Departamentos Departamentos){
        return repository.save(Departamentos);
    }

    //Actualiza el departamento
    public Departamentos updateDepartamentos(Long id, Departamentos Departamentos){
        Optional<Departamentos> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException(String.format("El Departamento con el id %s no fue encontrado", id));
        }
        Departamentos.setId(id);
        return  repository.save(Departamentos);
    }

    //Elimina por Id
    public String deleteDepartamentos(Long id){
        repository.deleteById(id);
        return "Departamento eliminado correctamente";
    }
}

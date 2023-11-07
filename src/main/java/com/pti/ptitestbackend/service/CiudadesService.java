package com.pti.ptitestbackend.service;

import com.pti.ptitestbackend.model.Ciudades;
import com.pti.ptitestbackend.repository.CiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadesService {
    
    @Autowired
    private CiudadesRepository repository;

    //Lista todas los Ciudadess
    public List<Ciudades> getAll(){
        return repository.findAll();
    }

    //Obtiene por Id la ciudad
    public Ciudades getCiudadessById(Long id){
        Optional<Ciudades> Ciudadess = repository.findById(id);
        return Ciudadess.orElseGet(Ciudades::new);
    }

    //Crea una nueva ciudad
    public Ciudades addCiudadess(Ciudades Ciudadess){
        return repository.save(Ciudadess);
    }

    //Actualiza la ciudad
    public Ciudades updateCiudadess(Long id, Ciudades Ciudadess){
        Optional<Ciudades> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException(String.format("El Ciudades con el id %s no fue encontrado", id));
        }
        Ciudadess.setId(id);
        return  repository.save(Ciudadess);
    }

    //Elimina por Id
    public void deleteCiudadess(Long id){
        Optional<Ciudades> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException(String.format("El Ciudades con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }
}

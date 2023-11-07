package com.pti.ptitestbackend.controller;

import com.pti.ptitestbackend.model.Ciudades;
import com.pti.ptitestbackend.service.CiudadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/ciudades")
public class CiudadesController extends GenericController {
    @Autowired
    private CiudadesService service;

    @GetMapping
    public ResponseEntity<List<Ciudades>> list(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Ciudades entidad = service.getCiudadessById(id);
            return success(entidad);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Ciudades Ciudades ) {
        try{
            Ciudades CiudadessAdd = service.addCiudadess(Ciudades);
            return success(CiudadessAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Ciudades obj) {
        try {
            Ciudades Ciudades = service.updateCiudadess(id, obj);
            return success(Ciudades);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteCiudadess(id);
            return deleteRequest();
        }catch (Exception e) {
            return badRequest(e);
        }
    }
}

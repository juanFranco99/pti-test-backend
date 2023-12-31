package com.pti.ptitestbackend.controller;

import com.pti.ptitestbackend.model.Departamento;
import com.pti.ptitestbackend.service.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/departamentos")
public class DepartamentosController extends GenericController {

    @Autowired
    private DepartamentosService service;

    @GetMapping
    public ResponseEntity<List<Departamento>> list(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Departamento entidad = service.getDepartamentosById(id);
            return success(entidad);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Departamento departamento ) {
        try{
            Departamento departamentosAdd = service.addDepartamentos(departamento);
            return success(departamentosAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Departamento obj) {
        try {
            Departamento departamento = service.updateDepartamentos(id, obj);
            return success(departamento);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteDepartamentos(id);
            return deleteRequest();
        }catch (Exception e) {
            return badRequest(e);
        }
    }

}

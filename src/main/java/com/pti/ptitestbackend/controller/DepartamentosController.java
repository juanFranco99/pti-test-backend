package com.pti.ptitestbackend.controller;

import com.pti.ptitestbackend.model.Departamentos;
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
    public ResponseEntity<List<Departamentos>> list(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Departamentos entidad = service.getDepartamentosById(id);
            return success(entidad);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Departamentos departamento ) {
        try{
            Departamentos departamentosAdd = service.addDepartamentos(departamento);
            return success(departamentosAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Departamentos obj) {
        try {
            Departamentos departamento = service.updateDepartamentos(id, obj);
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

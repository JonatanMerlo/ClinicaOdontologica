package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entities.Turno;
import com.example.ClinicaOdontologica.service.impl.TurnoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/turnos")
@CrossOrigin(origins = "http://localhost:3000")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @GetMapping
    public List<Turno> listAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Turno> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Turno turno) {
        ResponseEntity.ok(turno);
        service.save(turno);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Turno turno) {
        turno.setId(id);
        service.update(turno);
    }


}

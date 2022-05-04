package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entities.Paciente;
import com.example.ClinicaOdontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/pacientes")
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(path = "/{id}")
    private ResponseEntity<Optional<Paciente>> getById(@PathVariable Long id){
        Optional<Paciente> pacienteResponse = service.findById(id);
        return ResponseEntity.ok(pacienteResponse);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping
    private List<Paciente> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        if(validationBody(paciente)){
            service.save(paciente);
            return ResponseEntity.ok(paciente);
        }else{
            return ResponseEntity.badRequest().body(paciente);
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        service.update(paciente);
    }


    public Boolean validationBody(Paciente paciente) {
        boolean body;
        if (paciente.getApellido() != null && paciente.getNombre() != null && paciente.getDni() != null) {
            body = true;
        } else body = false;
        return body;
    }

}

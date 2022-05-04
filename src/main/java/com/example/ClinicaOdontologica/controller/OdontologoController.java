package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entities.Odontologo;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/*@RequestMapping(path= "/odontologos")*/
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class OdontologoController {

    @Autowired
    private OdontologoService service;

    @PostMapping
    public Odontologo save(@RequestBody Odontologo odontologo){
        return service.save(odontologo);
    }

    @GetMapping("/odontologos")
    public List<Odontologo> getAll(){
        return service.findAll();
    }



    @GetMapping("/{id}")
    private ResponseEntity<Optional<Odontologo>> getById(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologoResponse = service.findById(id);
        return ResponseEntity.ok(odontologoResponse);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PutMapping("/{id}")
    private ResponseEntity putById(@PathVariable Long id, @RequestBody Odontologo odontologo) throws ResourceNotFoundException{
        odontologo.setId(id);
        service.update(odontologo);
        return ResponseEntity.ok(odontologo);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> procesarErrorNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}


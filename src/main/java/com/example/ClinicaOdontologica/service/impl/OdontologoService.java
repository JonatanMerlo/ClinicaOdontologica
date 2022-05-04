package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.Repository.IOdontologoRepository;
import com.example.ClinicaOdontologica.entities.Odontologo;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;

    public Odontologo save(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> findAll(){
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> findById(Long id) throws ResourceNotFoundException{
        if(!odontologoRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("No existe un odontologo con el id " + id);
        }

        return odontologoRepository.findById(id);
    }

    public void delete(Long id) throws ResourceNotFoundException{
        Odontologo odontologo = findById(id).orElse(null);
        odontologoRepository.delete(odontologo);
    }

    public void update(Odontologo odontologo) throws ResourceNotFoundException{
        if(findById(odontologo.getId()).isPresent()){
            odontologoRepository.saveAndFlush(odontologo);
        }
    }
}

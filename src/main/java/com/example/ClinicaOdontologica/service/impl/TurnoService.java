package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.Repository.ITurnoRepository;
import com.example.ClinicaOdontologica.entities.Paciente;
import com.example.ClinicaOdontologica.entities.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    public Turno save(Turno turno){
        return turnoRepository.save(turno);
    }

    public List<Turno> findAll(){
        return turnoRepository.findAll();
    }

    public Optional<Turno> findById(Long id){
        Optional<Turno> turno = turnoRepository.findById(id);
        return turno;
    }

    public void delete(Long id){
        turnoRepository.deleteById(id);
    }

    public void update(Turno turno){
        turnoRepository.saveAndFlush(turno);
    }



}

package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.Repository.IPacienteRepository;
import com.example.ClinicaOdontologica.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente;
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public void update(Paciente paciente){
        pacienteRepository.saveAndFlush(paciente);
    }

}

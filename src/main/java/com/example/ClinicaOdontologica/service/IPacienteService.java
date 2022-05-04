package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    Paciente save(Paciente paciente);

    List<Paciente> findAll();

    Optional<Paciente> findById(Long id);

    void deleteById(Long id);

    void update(Paciente paciente);
}

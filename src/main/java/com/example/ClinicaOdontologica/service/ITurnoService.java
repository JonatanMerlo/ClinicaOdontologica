package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entities.Turno;

import java.util.List;

public interface ITurnoService {


    void save(Turno turno);

    List<Turno> findAll();

    Turno findById(Long id);

    void deleteById(Long id);

    void update(Turno turno);
}

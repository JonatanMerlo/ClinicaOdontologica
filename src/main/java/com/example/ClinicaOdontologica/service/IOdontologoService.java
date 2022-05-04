package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entities.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    Odontologo save(Odontologo odontologo);

    List<Odontologo> findAll();

    Optional<Odontologo> findById(Long id);

    void deleteById(Long id);

    void update(Odontologo odontologo);

}
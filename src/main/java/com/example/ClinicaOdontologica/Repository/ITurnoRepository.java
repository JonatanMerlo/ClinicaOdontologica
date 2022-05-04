package com.example.ClinicaOdontologica.Repository;

import com.example.ClinicaOdontologica.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}

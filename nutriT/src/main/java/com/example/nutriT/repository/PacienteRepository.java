package com.example.nutriT.repository;

import com.example.nutriT.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByEmail(String email);
}


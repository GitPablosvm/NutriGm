package com.example.nutriT.repository;

import com.example.nutriT.model.PlanNutricional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanNutricionalRepository extends JpaRepository<PlanNutricional, Long> {
    Optional<PlanNutricional> findByPacienteId(Long pacienteId);
}
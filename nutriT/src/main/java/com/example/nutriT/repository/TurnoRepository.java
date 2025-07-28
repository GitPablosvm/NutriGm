package com.example.nutriT.repository;

import com.example.nutriT.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByPacienteId(Long pacienteId);
    List<Turno> findByMedicoId(Long medicoId);
    
    boolean existsByMedicoIdAndFechaHora(Long medicoId, LocalDateTime fechaHora);
}


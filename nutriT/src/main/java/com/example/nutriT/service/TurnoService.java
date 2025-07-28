package com.example.nutriT.service;

import com.example.nutriT.dto.TurnoDto;

import java.util.List;

public interface TurnoService {
    TurnoDto crearTurno(TurnoDto turnoDto);
    TurnoDto cancelarTurno(Long id);
    TurnoDto actualizarTurno(Long id, String estado, String notas);
    List<TurnoDto> obtenerTurnosPorPaciente(Long pacienteId);
    List<TurnoDto> obtenerTurnosPorMedico(Long medicoId);
}
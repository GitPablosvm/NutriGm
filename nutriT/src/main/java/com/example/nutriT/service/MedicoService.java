package com.example.nutriT.service;

import java.util.List;

import com.example.nutriT.dto.MedicoDto;
import com.example.nutriT.dto.PacienteDto;

public interface MedicoService {
	MedicoDto crearMedico(MedicoDto medicoDto);
	List<MedicoDto> obtenerTodos();
    PacienteDto actualizarDatosPaciente(Long id, PacienteDto dto);
}
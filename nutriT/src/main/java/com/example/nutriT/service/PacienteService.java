package com.example.nutriT.service;

import com.example.nutriT.dto.PacienteRegistroDto;
import com.example.nutriT.dto.UsuarioDto;
import com.example.nutriT.dto.PacienteDto;

public interface PacienteService {
    UsuarioDto registrarPaciente(PacienteRegistroDto dto);
    PacienteDto obtenerDatos(Long id);
}
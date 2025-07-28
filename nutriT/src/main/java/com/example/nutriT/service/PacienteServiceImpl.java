package com.example.nutriT.service;

import com.example.nutriT.dto.PacienteRegistroDto;
import com.example.nutriT.dto.UsuarioDto;
import com.example.nutriT.dto.PacienteDto;
import com.example.nutriT.model.Paciente;
import com.example.nutriT.model.Rol;
import com.example.nutriT.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto registrarPaciente(PacienteRegistroDto dto) {
        if (pacienteRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        Paciente nuevo = new Paciente(
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getContrasena()),
                Rol.PACIENTE,
                dto.getPesoActual(),
                dto.getPesoObjetivo(),
                dto.getObservaciones()
        );

        nuevo.setFechaCreacion(LocalDateTime.now());

        Paciente guardado = pacienteRepository.save(nuevo);

        return new UsuarioDto(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getApellido(),
                guardado.getEmail(),
                guardado.getRol().name()
        );
    }

    @Override
    public PacienteDto obtenerDatos(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        return new PacienteDto(
                paciente.getId(),
                paciente.getPesoActual(),
                paciente.getPesoObjetivo(),
                paciente.getObservaciones()
        );
    }
}
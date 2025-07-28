package com.example.nutriT.service;

import com.example.nutriT.dto.MedicoDto;
import com.example.nutriT.dto.PacienteDto;
import com.example.nutriT.model.Medico;
import com.example.nutriT.model.Paciente;
import com.example.nutriT.model.Rol;
import com.example.nutriT.repository.MedicoRepository;
import com.example.nutriT.repository.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PacienteDto actualizarDatosPaciente(Long id, PacienteDto dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        paciente.setPesoActual(dto.getPesoActual());
        paciente.setPesoObjetivo(dto.getPesoObjetivo());
        paciente.setObservaciones(dto.getObservaciones());

        Paciente actualizado = pacienteRepository.save(paciente);

        return new PacienteDto(
                actualizado.getId(),
                actualizado.getPesoActual(),
                actualizado.getPesoObjetivo(),
                actualizado.getObservaciones()
        );
    }
    
    @Override
    public MedicoDto crearMedico(MedicoDto dto) {
        Medico medico = new Medico();
        medico.setNombre(dto.getNombre());
        medico.setApellido(dto.getApellido());
        medico.setEmail(dto.getEmail());
        medico.setContrasena(passwordEncoder.encode("medico123"));
        medico.setMatricula(dto.getMatricula());
        medico.setEspecialidad(dto.getEspecialidad());

        Medico guardado = medicoRepository.save(medico);

        return new MedicoDto(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getApellido(),
                guardado.getEmail(),
                guardado.getMatricula(),
                guardado.getEspecialidad()
        );
    }

    @Override
    public List<MedicoDto> obtenerTodos() {
        return medicoRepository.findAll().stream().map(medico ->
                new MedicoDto(
                        medico.getId(),
                        medico.getNombre(),
                        medico.getApellido(),
                        medico.getEmail(),
                        medico.getMatricula(),
                        medico.getEspecialidad()
                )
        ).collect(Collectors.toList());
    }   
}

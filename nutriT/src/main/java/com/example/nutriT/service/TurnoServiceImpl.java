package com.example.nutriT.service;

import com.example.nutriT.dto.TurnoDto;
import com.example.nutriT.model.Medico;
import com.example.nutriT.model.Paciente;
import com.example.nutriT.model.Turno;
import com.example.nutriT.model.Usuario;
import com.example.nutriT.repository.MedicoRepository;
import com.example.nutriT.repository.PacienteRepository;
import com.example.nutriT.repository.TurnoRepository;
import com.example.nutriT.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public TurnoDto crearTurno(TurnoDto dto) {
        if (dto.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("No se puede crear un turno en el pasado");
        }

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        boolean existeSolapamiento = turnoRepository.existsByMedicoIdAndFechaHora(dto.getMedicoId(), dto.getFechaHora());
        if (existeSolapamiento) {
            throw new RuntimeException("Ya existe un turno para ese médico en ese horario");
        }

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setMedico(medico);
        turno.setFechaHora(dto.getFechaHora());
        turno.setEstado(dto.getEstado().toUpperCase());
        turno.setNotasMedicas(dto.getNotasMedicas());

        turnoRepository.save(turno);

        return new TurnoDto(
                turno.getId(),
                paciente.getId(),
                medico.getId(),
                turno.getFechaHora(),
                turno.getEstado(),
                turno.getNotasMedicas()
        );
    }

    @Override
    public TurnoDto cancelarTurno(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        turno.setEstado("CANCELADO");
        turnoRepository.save(turno);
        return new TurnoDto(turno.getId(), turno.getPaciente().getId(), turno.getMedico().getId(), turno.getFechaHora(), turno.getEstado(), turno.getNotasMedicas());
    }

    @Override
    public List<TurnoDto> obtenerTurnosPorPaciente(Long pacienteId) {
        return turnoRepository.findByPacienteId(pacienteId).stream()
                .map(t -> new TurnoDto(t.getId(), t.getPaciente().getId(), t.getMedico().getId(), t.getFechaHora(), t.getEstado(), t.getNotasMedicas()))
                .collect(Collectors.toList());
    }

    @Override
    public TurnoDto actualizarTurno(Long id, String estado, String notas) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        if (estado != null && !estado.isEmpty()) {
            turno.setEstado(estado.toUpperCase());
        }

        if (notas != null) {
            turno.setNotasMedicas(notas);
        }

        Turno actualizado = turnoRepository.save(turno);

        return new TurnoDto(
            actualizado.getId(),
            actualizado.getPaciente().getId(),
            actualizado.getMedico().getId(),
            actualizado.getFechaHora(),
            actualizado.getEstado(),
            actualizado.getNotasMedicas()
        );
    }
    
    @Override
    public List<TurnoDto> obtenerTurnosPorMedico(Long medicoId) {
        return turnoRepository.findByMedicoId(medicoId).stream()
                .map(t -> new TurnoDto(t.getId(), t.getPaciente().getId(), t.getMedico().getId(), t.getFechaHora(), t.getEstado(), t.getNotasMedicas()))
                .collect(Collectors.toList());
    }
}

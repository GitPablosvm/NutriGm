package com.example.nutriT.controller;

import com.example.nutriT.dto.TurnoActualizarDto;
import com.example.nutriT.dto.TurnoDto;
import com.example.nutriT.service.TurnoService;
import com.example.nutriT.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasRole('PACIENTE')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDto turnoDto) {
        try {
            TurnoDto creado = turnoService.crearTurno(turnoDto);
            return ResponseEntity.ok(creado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('PACIENTE', 'MEDICO')")
    @PutMapping("/cancelar/{id}")
    public ResponseEntity<TurnoDto> cancelarTurno(@PathVariable Long id) {
        TurnoDto cancelado = turnoService.cancelarTurno(id);
        return ResponseEntity.ok(cancelado);
    }

    @PreAuthorize("hasRole('PACIENTE')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TurnoDto>> turnosPorPaciente(@PathVariable Long pacienteId) {
        List<TurnoDto> turnos = turnoService.obtenerTurnosPorPaciente(pacienteId);
        return ResponseEntity.ok(turnos);
    }

    @PreAuthorize("hasRole('MEDICO')")
    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<TurnoDto>> turnosPorMedico(@PathVariable Long medicoId) {
        List<TurnoDto> turnos = turnoService.obtenerTurnosPorMedico(medicoId);
        return ResponseEntity.ok(turnos);
    }

    @PreAuthorize("hasRole('MEDICO')")
    @GetMapping("/historial/{pacienteId}")
    public ResponseEntity<List<TurnoDto>> historialDelPaciente(@PathVariable Long pacienteId) {
        List<TurnoDto> historial = turnoService.obtenerTurnosPorPaciente(pacienteId).stream()
                .filter(t -> t.getEstado().equalsIgnoreCase("REALIZADO"))
                .toList();
        return ResponseEntity.ok(historial);
    }
    
    @PreAuthorize("hasRole('MEDICO')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TurnoDto> actualizarTurno(
            @PathVariable Long id,
            @RequestBody TurnoActualizarDto actualizarDto) {

        TurnoDto turnoActualizado = turnoService.actualizarTurno(id,
                actualizarDto.getEstado(),
                actualizarDto.getNotas());

        return ResponseEntity.ok(turnoActualizado);
    }
}

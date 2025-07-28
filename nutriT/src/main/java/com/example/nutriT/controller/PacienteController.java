package com.example.nutriT.controller;

import com.example.nutriT.dto.PacienteDto;
import com.example.nutriT.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PreAuthorize("hasRole('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> obtenerDatosPaciente(@PathVariable Long id) {
        PacienteDto dto = pacienteService.obtenerDatos(id);
        return ResponseEntity.ok(dto);
    }
}
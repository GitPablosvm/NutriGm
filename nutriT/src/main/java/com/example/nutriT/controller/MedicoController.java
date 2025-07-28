package com.example.nutriT.controller;

import com.example.nutriT.dto.PacienteDto;
import com.example.nutriT.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PreAuthorize("hasRole('MEDICO')")
    @PutMapping("/paciente/{id}/actualizar")
    public ResponseEntity<PacienteDto> actualizarDatosPaciente(@PathVariable Long id, @RequestBody PacienteDto dto) {
        PacienteDto actualizado = medicoService.actualizarDatosPaciente(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
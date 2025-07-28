package com.example.nutriT.controller;

import com.example.nutriT.dto.PlanNutricionalDto;
import com.example.nutriT.service.PlanNutricionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "*")
public class PlanNutricionalController {

    @Autowired
    private PlanNutricionalService planService;

    @PreAuthorize("hasRole('PACIENTE')")
    @GetMapping("/{pacienteId}")
    public ResponseEntity<PlanNutricionalDto> verPlan(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(planService.obtenerPlan(pacienteId));
    }

    @PreAuthorize("hasRole('MEDICO')")
    @PostMapping("/guardar")
    public ResponseEntity<PlanNutricionalDto> guardarPlan(@RequestBody PlanNutricionalDto dto) {
        return ResponseEntity.ok(planService.guardarPlan(dto));
    }
}

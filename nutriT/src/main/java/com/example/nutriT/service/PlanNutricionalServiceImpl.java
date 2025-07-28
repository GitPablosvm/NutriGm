package com.example.nutriT.service;

import com.example.nutriT.dto.PlanNutricionalDto;
import com.example.nutriT.model.Paciente;
import com.example.nutriT.model.PlanNutricional;
import com.example.nutriT.repository.PacienteRepository;
import com.example.nutriT.repository.PlanNutricionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanNutricionalServiceImpl implements PlanNutricionalService {

    @Autowired
    private PlanNutricionalRepository planRepo;

    @Autowired
    private PacienteRepository pacienteRepo;

    @Override
    public PlanNutricionalDto obtenerPlan(Long pacienteId) {
        PlanNutricional plan = planRepo.findByPacienteId(pacienteId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        return new PlanNutricionalDto(plan.getPaciente().getId(), plan.getContenido());
    }

    @Override
    public PlanNutricionalDto guardarPlan(PlanNutricionalDto dto) {
        Paciente paciente = pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        PlanNutricional plan = planRepo.findByPacienteId(dto.getPacienteId())
                .orElse(new PlanNutricional(paciente, ""));

        plan.setContenido(dto.getContenido());
        plan.setPaciente(paciente);

        PlanNutricional guardado = planRepo.save(plan);

        return new PlanNutricionalDto(guardado.getPaciente().getId(), guardado.getContenido());
    }
}
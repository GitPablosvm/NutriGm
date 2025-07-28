package com.example.nutriT.service;

import com.example.nutriT.dto.PlanNutricionalDto;

public interface PlanNutricionalService {
    PlanNutricionalDto obtenerPlan(Long pacienteId);
    PlanNutricionalDto guardarPlan(PlanNutricionalDto dto);
}
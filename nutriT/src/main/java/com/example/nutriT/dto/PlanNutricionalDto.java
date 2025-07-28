package com.example.nutriT.dto;

public class PlanNutricionalDto {
    private Long pacienteId;
    private String contenido;
    
    //Constructor
    public PlanNutricionalDto() {}

    public PlanNutricionalDto(Long pacienteId, String contenido) {
        this.pacienteId = pacienteId;
        this.contenido = contenido;
    }
    
    //Getter and Setters
    public Long getPacienteId() { 
    	return pacienteId; }
    
    public void setPacienteId(Long pacienteId) { 
    	this.pacienteId = pacienteId; }

    public String getContenido() { 
    	return contenido; }
    
    public void setContenido(String contenido) { 
    	this.contenido = contenido; }
}
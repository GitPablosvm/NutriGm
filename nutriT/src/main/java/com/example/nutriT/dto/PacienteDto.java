package com.example.nutriT.dto;

public class PacienteDto {
    private Long id;
    private Double pesoActual;
    private Double pesoObjetivo;
    private String observaciones;

    //Construcctor
    public PacienteDto() {}

    public PacienteDto(Long id, Double pesoActual, Double pesoObjetivo, String observaciones) {
        this.id = id;
        this.pesoActual = pesoActual;
        this.pesoObjetivo = pesoObjetivo;
        this.observaciones = observaciones;
    }
    
    //Getter and Setter
    public Long getId() { 
    	return id; }
    
    public void setId(Long id) { 
    	this.id = id; }

    public Double getPesoActual() { 
    	return pesoActual; }
    
    public void setPesoActual(Double pesoActual) 
    { this.pesoActual = pesoActual; }

    public Double getPesoObjetivo() { 
    	return pesoObjetivo; }
    
    public void setPesoObjetivo(Double pesoObjetivo) { 
    	this.pesoObjetivo = pesoObjetivo; }

    public String getObservaciones() { 
    	return observaciones; }
    
    public void setObservaciones(String observaciones) { 
    	this.observaciones = observaciones; }
}

package com.example.nutriT.dto;

import java.time.LocalDateTime;

public class TurnoDto {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime fechaHora;
    private String estado;
    private String notasMedicas;

    //Constructor
    public TurnoDto() {}

    public TurnoDto(Long id, Long pacienteId, Long medicoId, LocalDateTime fechaHora, String estado, String notasMedicas) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.notasMedicas = notasMedicas;
    }

    //Getter and setter
    
    public Long getId() { 
    	return id; }
    
    public void setId(Long id) { 
    	this.id = id; }

    public Long getPacienteId() { 
    	return pacienteId; }
    
    public void setPacienteId(Long pacienteId) { 
    	this.pacienteId = pacienteId; }

    public Long getMedicoId() { 
    	return medicoId; }
    
    public void setMedicoId(Long medicoId) { 
    	this.medicoId = medicoId; }

    public LocalDateTime getFechaHora() { 
    	return fechaHora; }
    
    public void setFechaHora(LocalDateTime fechaHora) { 
    	this.fechaHora = fechaHora; }

    public String getEstado() { 
    	return estado; }
    
    public void setEstado(String estado) { 
    	this.estado = estado; }

    public String getNotasMedicas() { 
    	return notasMedicas; }
    
    public void setNotasMedicas(String notasMedicas) { 
    	this.notasMedicas = notasMedicas; }
}
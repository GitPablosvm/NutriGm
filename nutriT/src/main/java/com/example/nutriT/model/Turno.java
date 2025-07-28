package com.example.nutriT.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Usuario medico;

    private LocalDateTime fechaHora;
    private String estado;
    private String notasMedicas;

    //Constructor
    public Turno() {}

    
    //Getter and Setters
    
    public Long getId() {
    	return id; }
    
    public void setId(Long id) {
    	this.id = id; }

    public Usuario getPaciente() {
    	return paciente; }
    public void setPaciente(Usuario paciente) {
    	this.paciente = paciente; }

    public Usuario getMedico() {
    	return medico; }
    
    public void setMedico(Usuario medico) {
    	this.medico = medico; }

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
package com.example.nutriT.model;

import jakarta.persistence.*;

@Entity
public class PlanNutricional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", unique = true)
    private Paciente paciente;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    //Constructor
    public PlanNutricional() {}

    public PlanNutricional(Paciente paciente, String contenido) {
        this.paciente = paciente;
        this.contenido = contenido;
    }
    
    //Getter and Setters
    public Long getId() { 
    	return id; }
    
    public Paciente getPaciente() { 
    	return paciente; }
    
    public void setPaciente(Paciente paciente) { 
    	this.paciente = paciente; }

    public String getContenido() { 
    	return contenido; }
    
    public void setContenido(String contenido) { 
    	this.contenido = contenido; }
}

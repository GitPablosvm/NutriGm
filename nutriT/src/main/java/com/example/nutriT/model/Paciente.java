package com.example.nutriT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario {

    @Column(name = "peso_actual")
    private Double pesoActual;

    @Column(name = "peso_objetivo")
    private Double pesoObjetivo;

    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    // Constructor
    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String email, String contrasena, Rol rol,
                    Double pesoActual, Double pesoObjetivo, String observaciones) {
        super(nombre, apellido, email, contrasena, rol);
        this.pesoActual = pesoActual;
        this.pesoObjetivo = pesoObjetivo;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Double getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(Double pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

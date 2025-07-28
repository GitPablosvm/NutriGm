package com.example.nutriT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Medico extends Usuario {

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private String especialidad;

    //Constructor
    public Medico() {}

    public Medico(String matricula, String especialidad) {
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    //Getter and Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
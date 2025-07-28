package com.example.nutriT.dto;

public class MedicoDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String matricula;
    private String especialidad;
    
    //Constructores
    public MedicoDto() {}

    public MedicoDto(Long id, String nombre, String apellido, String email, String matricula, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
    
    //Getter and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

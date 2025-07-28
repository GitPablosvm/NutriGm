package com.example.nutriT.dto;

public class PacienteRegistroDto {
	
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private Double pesoActual;
    private Double pesoObjetivo;
    private String observaciones;

    //Constructores
    public PacienteRegistroDto() {}

    public PacienteRegistroDto(String nombre, String apellido, String email, String contrasena,
                                Double pesoActual, Double pesoObjetivo, String observaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.pesoActual = pesoActual;
        this.pesoObjetivo = pesoObjetivo;
        this.observaciones = observaciones;
    }
    
    //Getter and Setter

    public String getNombre() { 
    	return nombre; }
    
    public void setNombre(String nombre) { 
    	this.nombre = nombre; }

    public String getApellido() { 
    	return apellido; }
    
    public void setApellido(String apellido) { 
    	this.apellido = apellido; }

    public String getEmail() { 
    	return email; }
    
    public void setEmail(String email) { 
    	this.email = email; }

    public String getContrasena() { 
    	return contrasena; }
    
    public void setContrasena(String contrasena) { 
    	this.contrasena = contrasena; }

    public Double getPesoActual() { 
    	return pesoActual; }
    
    public void setPesoActual(Double pesoActual) { 
    	this.pesoActual = pesoActual; }

    public Double getPesoObjetivo() { 
    	return pesoObjetivo; }
    
    public void setPesoObjetivo(Double pesoObjetivo) { 
    	this.pesoObjetivo = pesoObjetivo; }

    public String getObservaciones() { 
    	return observaciones; }
    
    public void setObservaciones(String observaciones) { 
    	this.observaciones = observaciones; }
}

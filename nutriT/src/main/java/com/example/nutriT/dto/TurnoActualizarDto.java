package com.example.nutriT.dto;

public class TurnoActualizarDto {
    private String estado;
    private String notas;

    //Construcctor
    public TurnoActualizarDto() {}

    public TurnoActualizarDto(String estado, String notas) {
        this.estado = estado;
        this.notas = notas;
    }

    //Getter and Setter
    public String getEstado() { 
    	return estado; }
    
    public void setEstado(String estado) {
    	this.estado = estado; }

    public String getNotas() { 
    	return notas; }
    
    public void setNotas(String notas) { 
    	this.notas = notas; }
}
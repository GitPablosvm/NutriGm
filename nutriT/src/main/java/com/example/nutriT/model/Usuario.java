package com.example.nutriT.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String email;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaUltimaConexion;

    //Constructores
    public Usuario() {}

    public Usuario(String nombre, String apellido, String email, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
        this.fechaCreacion = LocalDateTime.now();
    }

    //Getters y Setters
    public Long getId() {
    	return id; }

    public void setId(Long id) {
    	this.id = id; }

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

    public Rol getRol() { 
    	return rol; }

    public void setRol(Rol rol) { 
    	this.rol = rol; }

    public LocalDateTime getFechaCreacion() { 
    	return fechaCreacion; }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
    	this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaUltimaConexion() { 
    	return fechaUltimaConexion; }

    public void setFechaUltimaConexion(LocalDateTime fechaUltimaConexion) { 
    	this.fechaUltimaConexion = fechaUltimaConexion; }
}

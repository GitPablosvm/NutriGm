package com.example.nutriT.dto;

public class LoginDto {
    private Long id;
    private String email;
    private String rol;
    private String token;
    private String contrasena;
    
    //Construcctor

    public LoginDto() {}

    public LoginDto(Long id, String email, String rol, String token) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.token = token;
    }

    //Getter and Setters
    
    public Long getId() { 
    	return id; }
    
    public void setId(Long id) { 
    	this.id = id; }

    public String getEmail() { 
    	return email; }
    
    public void setEmail(String email) { 
    	this.email = email; }

    public String getRol() { 
    	return rol; }
    
    public void setRol(String rol) { 
    	this.rol = rol; }

    public String getToken() { 
    	return token; }
    
    public void setToken(String token) { 
    	this.token = token; }

    public String getContrasena() { 
    	return contrasena; }
    
    public void setContrasena(String contrasena) { 
    	this.contrasena = contrasena; }
}


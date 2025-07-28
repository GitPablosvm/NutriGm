package com.example.nutriT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nutriT.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{
	
	Optional<Usuario> findByEmail(String email);
	
	boolean existsByEmail(String Email);

}

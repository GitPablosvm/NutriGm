package com.example.nutriT.service;

import com.example.nutriT.dto.LoginDto;
import com.example.nutriT.dto.UsuarioDto;

public interface UsuarioService {
    LoginDto login(LoginDto loginDto);
    UsuarioDto buscarPorEmail(String email);
}
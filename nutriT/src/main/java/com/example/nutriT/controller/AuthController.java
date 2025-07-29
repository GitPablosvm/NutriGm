package com.example.nutriT.controller;

import com.example.nutriT.dto.*;
import com.example.nutriT.service.MedicoService;
import com.example.nutriT.service.PacienteService;
import com.example.nutriT.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;
    
    @Autowired
    private MedicoService medicoService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registrarPaciente(@RequestBody PacienteRegistroDto dto) {
        UsuarioDto nuevo = pacienteService.registrarPaciente(dto);
        return ResponseEntity.ok(nuevo);
    }
    
    @PostMapping("/crear-medico")
    public ResponseEntity<MedicoDto> registrarMedico(@RequestBody MedicoDto dto) {
        MedicoDto nuevo = medicoService.crearMedico(dto);
        return ResponseEntity.ok(nuevo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        LoginDto respuesta = usuarioService.login(loginDto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<UsuarioDto> buscarPorEmail(@PathVariable String email) {
        UsuarioDto dto = usuarioService.buscarPorEmail(email);
        return ResponseEntity.ok(dto);
    }

}

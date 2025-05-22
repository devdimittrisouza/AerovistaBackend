package com.aerovistadrones.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.dto.UsuarioDto;
import com.aerovistadrones.app.entities.UsuarioEntity;
import com.aerovistadrones.app.repository.LoginRepository;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
    private LoginRepository loginRepository;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody UsuarioDto usuarioDto){
		Optional<UsuarioEntity> usuario = loginRepository.findByEmailAndSenha(
				usuarioDto.getEmail(), usuarioDto.getSenha()
		);
		
		if(usuario.isPresent()) {
			return ResponseEntity.ok("Login realizado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
		}
	}
}

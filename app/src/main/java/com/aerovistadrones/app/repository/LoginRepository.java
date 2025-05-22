package com.aerovistadrones.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aerovistadrones.app.entities.UsuarioEntity;

public interface LoginRepository extends JpaRepository<UsuarioEntity, Integer>{
	
	Optional<UsuarioEntity> findByEmailAndSenha(String email, String senha);

}

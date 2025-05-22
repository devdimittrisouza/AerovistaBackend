package com.aerovistadrones.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UsuarioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_PW")
    private String senha;

    @Column(name = "USER_NAME")
    private String nome;
    
    public UsuarioEntity() {
    	
    }
    
	public UsuarioEntity(Integer id, String email, String senha, String nome) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
}

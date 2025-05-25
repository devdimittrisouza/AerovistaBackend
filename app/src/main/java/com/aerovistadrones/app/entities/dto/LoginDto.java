package com.aerovistadrones.app.entities.dto;

public class LoginDto {

	private String loginEmail;
	private String loginSenha;
	
	public LoginDto() {
		
	}
	
	public LoginDto(String loginEmail, String loginSenha) {
		super();
		this.loginEmail = loginEmail;
		this.loginSenha = loginSenha;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginSenha() {
		return loginSenha;
	}
	public void setLoginSenha(String loginSenha) {
		this.loginSenha = loginSenha;
	}
	
}

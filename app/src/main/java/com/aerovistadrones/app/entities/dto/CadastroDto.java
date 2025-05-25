package com.aerovistadrones.app.entities.dto;

public class CadastroDto {

	private Integer cadId;
	private String cadNome;
	private String cadEmail;
	private String cadTel;
	private String cadCpf;
	private String cadSenha;
	
	public CadastroDto() {
		
	}

	public CadastroDto(Integer cadId, String cadNome, String cadEmail, String cadTel, String cadCpf, String cadSenha) {
		this.cadId = cadId;
		this.cadNome = cadNome;
		this.cadEmail = cadEmail;
		this.cadTel = cadTel;
		this.cadCpf = cadCpf;
		this.cadSenha = cadSenha;
	}

	public Integer getCadId() {
		return cadId;
	}

	public void setCadId(Integer cadId) {
		this.cadId = cadId;
	}

	public String getCadNome() {
		return cadNome;
	}

	public void setCadNome(String cadNome) {
		this.cadNome = cadNome;
	}

	public String getCadEmail() {
		return cadEmail;
	}

	public void setCadEmail(String cadEmail) {
		this.cadEmail = cadEmail;
	}

	public String getCadTel() {
		return cadTel;
	}

	public void setCadTel(String cadTel) {
		this.cadTel = cadTel;
	}

	public String getCadCpf() {
		return cadCpf;
	}

	public void setCadCpf(String cadCpf) {
		this.cadCpf = cadCpf;
	}

	public String getCadSenha() {
		return cadSenha;
	}

	public void setCadSenha(String cadSenha) {
		this.cadSenha = cadSenha;
	}
	
}

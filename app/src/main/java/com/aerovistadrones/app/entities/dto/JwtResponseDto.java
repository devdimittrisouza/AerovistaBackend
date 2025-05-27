package com.aerovistadrones.app.entities.dto;

public class JwtResponseDto {

	private String jwtToken;
	
	public JwtResponseDto(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
}

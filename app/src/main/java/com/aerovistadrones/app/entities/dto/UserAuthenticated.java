package com.aerovistadrones.app.entities.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthenticated implements UserDetails{

	private final LoginDto loginDto;
	
	public UserAuthenticated(LoginDto loginDto) {
		this.loginDto = loginDto;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "read");
	}

	@Override
	public String getPassword() {
		return loginDto.getLoginSenha();
	}

	@Override
	public String getUsername() {
		return loginDto.getLoginEmail();
	}

}

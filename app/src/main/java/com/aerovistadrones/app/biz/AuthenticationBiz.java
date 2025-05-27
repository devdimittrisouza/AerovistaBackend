package com.aerovistadrones.app.biz;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationBiz {
	
	private final JwtBiz jwtBiz;
	
	public AuthenticationBiz(JwtBiz jwtBiz) {
		this.jwtBiz = jwtBiz;
	}
	
	public String authenticate(Authentication authentication) {
		return jwtBiz.generateToken(authentication);
	}
}

package com.aerovistadrones.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.biz.AuthenticationBiz;

@RestController
public class AuthenticationController {

	private final AuthenticationBiz authBiz;
	
	public AuthenticationController(AuthenticationBiz authBiz) {
		this.authBiz = authBiz;
	}
	
	@PostMapping("authenticate")
	public String authenticate(Authentication authentication){
		return authBiz.authenticate(authentication);
	}
}

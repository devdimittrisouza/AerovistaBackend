package com.aerovistadrones.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.biz.LoginBiz;
import com.aerovistadrones.app.entities.dto.LoginDto;

@RestController
@RequestMapping("api/login")
public class LoginController {

	@Autowired private LoginBiz loginBiz;
	
	@PostMapping
	public int login(@RequestBody LoginDto loginDto) {
		
		boolean result = loginBiz.logar(loginDto);
		if(result) {
			return 1;
		}else {
			return 0;
		}
	}
}

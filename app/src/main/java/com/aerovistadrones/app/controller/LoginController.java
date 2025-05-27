package com.aerovistadrones.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.biz.LoginBiz;
import com.aerovistadrones.app.entities.dto.JwtResponseDto;
import com.aerovistadrones.app.entities.dto.LoginDto;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private LoginBiz loginBiz;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        String token = loginBiz.autenticarEObterToken(loginDto);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}

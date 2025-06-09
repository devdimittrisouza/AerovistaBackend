package com.aerovistadrones.app.controller;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.biz.CadastroBiz;
import com.aerovistadrones.app.entities.dto.CadastroDto;

@RestController
@RequestMapping("api/cadastrar")
public class CadastroController {

	@Autowired private CadastroBiz cadastroBiz;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody CadastroDto cadDto) {
		
		cadDto.setCadNome(sanitize(cadDto.getCadNome()));
        cadDto.setCadEmail(sanitize(cadDto.getCadEmail()));
        cadDto.setCadCpf(sanitize(cadDto.getCadCpf()));
        cadDto.setCadTel(sanitize(cadDto.getCadTel()));
        cadDto.setCadSenha(sanitize(cadDto.getCadSenha()));

        boolean result = cadastroBiz.cadastrar(cadDto);

        if (result) {
            return ResponseEntity.ok("Cadastro realizado com sucesso.");
        } else {
            return ResponseEntity.status(409).body("CPF já cadastrado.");
        }
		
	}
	
	private String sanitize(String input) {
        return Jsoup.clean(input, Safelist.none());
    }
}

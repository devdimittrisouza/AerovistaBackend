package com.aerovistadrones.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public int cadastrar(@RequestBody CadastroDto cadDto) {
		
		boolean result = cadastroBiz.cadastrar(cadDto);
		
		if(result) {
			return 1;
		}else {
			return 0;
		}
		
	}
}

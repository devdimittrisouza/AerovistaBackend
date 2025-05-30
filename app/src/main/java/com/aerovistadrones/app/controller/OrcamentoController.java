package com.aerovistadrones.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerovistadrones.app.biz.OrcamentoBiz;
import com.aerovistadrones.app.entities.dto.OrcamentoDto;

@RestController
@RequestMapping("/api/private/solicitacao/orcamento")
public class OrcamentoController {

	@Autowired
	private OrcamentoBiz orcBiz;

	@PostMapping
	public ResponseEntity<?> reqOrcamento(@RequestBody OrcamentoDto orcDto) {

		try {
			orcBiz.cadOrcamento(orcDto);
			return ResponseEntity.ok("Solicitação de orçamento salvo com sucesso!");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro interno");
		}
	}
}

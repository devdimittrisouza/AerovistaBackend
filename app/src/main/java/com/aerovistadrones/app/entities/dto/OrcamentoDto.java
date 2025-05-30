package com.aerovistadrones.app.entities.dto;

import java.time.LocalDateTime;

public class OrcamentoDto {

	private String orcTipoEvento;
	private LocalDateTime orcDataInicio;
	private LocalDateTime orcDataFim;
	private String orcComplementares;
	private Integer fkUserId;
	
	public OrcamentoDto() {
		
	}
	
	public OrcamentoDto(String orcTipoEvento, LocalDateTime orcDataInicio, LocalDateTime orcDataFim, String orcComplementares,
			Integer fkUserId) {
		this.orcTipoEvento = orcTipoEvento;
		this.orcDataInicio = orcDataInicio;
		this.orcDataFim = orcDataFim;
		this.orcComplementares = orcComplementares;
		this.fkUserId = fkUserId;
	}
	
	public String getOrcTipoEvento() {
		return orcTipoEvento;
	}
	public void setOrcTipoEvento(String orcTipoEvento) {
		this.orcTipoEvento = orcTipoEvento;
	}
	public LocalDateTime getOrcDataInicio() {
		return orcDataInicio;
	}
	public void setOrcDataInicio(LocalDateTime orcDataInicio) {
		this.orcDataInicio = orcDataInicio;
	}
	public LocalDateTime getOrcDataFim() {
		return orcDataFim;
	}
	public void setOrcDataFim(LocalDateTime orcDataFim) {
		this.orcDataFim = orcDataFim;
	}
	public String getOrcComplementares() {
		return orcComplementares;
	}
	public void setOrcComplementares(String orcComplementares) {
		this.orcComplementares = orcComplementares;
	}
	public Integer getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(Integer fkUserId) {
		this.fkUserId = fkUserId;
	}	
}

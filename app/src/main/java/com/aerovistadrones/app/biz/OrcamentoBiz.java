package com.aerovistadrones.app.biz;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import com.aerovistadrones.app.dao.OrcamentoDao;
import com.aerovistadrones.app.entities.dto.OrcamentoDto;

@Service
public class OrcamentoBiz {

	@Autowired private OrcamentoDao orcDao;
	
	public void cadOrcamento(OrcamentoDto orcDto) throws Exception {

		try {
			String email = getJwtEmail();
			
			Integer userId = orcDao.getUserIdByEmail(email);
			
			if(userId == null) throw new Exception("Usuário não encontrado");
			
			orcDto.setOrcTipoEvento(Jsoup.clean(orcDto.getOrcTipoEvento(), Safelist.basic()));
	        orcDto.setOrcComplementares(Jsoup.clean(orcDto.getOrcComplementares(), Safelist.basic()));
			
			orcDto.setFkUserId(userId);
			orcDao.insertOrcamento(orcDto);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public List<OrcamentoDto> listarOrcamentosDoUsuario() throws Exception {
	    try {
	        String email = getJwtEmail();
	        Integer userId = orcDao.getUserIdByEmail(email);

	        if(userId == null) throw new Exception("Usuário não encontrado");

	        return orcDao.getOrcamentosByUserId(userId);

	    } catch(Exception e) {
	        throw new Exception(e.getMessage());
	    }
	}

	private String getJwtEmail() {

		var authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof JwtAuthenticationToken jwtAuth) {
			return jwtAuth.getToken().getSubject();
		}
		return null;
	}
}

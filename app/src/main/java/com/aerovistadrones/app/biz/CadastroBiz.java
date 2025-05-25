package com.aerovistadrones.app.biz;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerovistadrones.app.dao.CadastroDao;
import com.aerovistadrones.app.entities.dto.CadastroDto;

@Service
public class CadastroBiz {

	@Autowired
	private CadastroDao cadastroDao;

	public boolean cadastrar(CadastroDto cadDto) {

		boolean success = false;

		if (!checkCpfExists(cadDto.getCadCpf())) {
			String hashedPw = BCrypt.hashpw(cadDto.getCadSenha(), BCrypt.gensalt(12));

			cadDto.setCadSenha(hashedPw);

			int sqlResult = cadastroDao.insertNewUsuario(cadDto);

			if (sqlResult > 0) {
				success = true;
			}
		}
		return success;
	}

	private boolean checkCpfExists(String cpf) {
		if (cadastroDao.checkCpfExists(cpf) > 0) {
			return true;
		} else {
			return false;
		}
	}
}

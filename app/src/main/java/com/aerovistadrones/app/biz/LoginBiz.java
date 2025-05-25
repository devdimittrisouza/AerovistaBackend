package com.aerovistadrones.app.biz;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerovistadrones.app.dao.LoginDao;
import com.aerovistadrones.app.entities.dto.LoginDto;

@Service
public class LoginBiz {

	@Autowired
	private LoginDao loginDao;

	public boolean logar(LoginDto loginDto) {

		boolean success = false;

		if (checkEmailExists(loginDto.getLoginEmail())) {

			String senhaBanco = loginDao.selectUserPw(loginDto.getLoginEmail());

			if (verificarSenha(loginDto.getLoginSenha(), senhaBanco))
				success = true;
		}
		return success;
	}

	private boolean checkEmailExists(String email) {
		if (loginDao.checkEmailExists(email) > 0) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean verificarSenha(String senhaForm, String senhaBd) {
		return BCrypt.checkpw(senhaForm, senhaBd);
	}
}

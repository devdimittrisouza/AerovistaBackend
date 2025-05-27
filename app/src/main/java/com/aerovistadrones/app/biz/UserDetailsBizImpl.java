package com.aerovistadrones.app.biz;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aerovistadrones.app.dao.LoginDao;
import com.aerovistadrones.app.entities.dto.LoginDto;

@Service
public class UserDetailsBizImpl implements UserDetailsService{

	private final LoginDao loginDao;
	
	public UserDetailsBizImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginDto loginDto = loginDao.getUserData(username);
		
		if(loginDto == null || loginDto.getLoginEmail() == null) {
			throw new UsernameNotFoundException("Usuário não encontrado: " + username);
		}
		
		return org.springframework.security.core.userdetails.User
	            .withUsername(loginDto.getLoginEmail())
	            .password(loginDto.getLoginSenha())
	            .authorities("USER") // ou use os papéis corretos
	            .build();
	}

}

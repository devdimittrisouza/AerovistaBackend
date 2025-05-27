package com.aerovistadrones.app.biz;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.aerovistadrones.app.dao.LoginDao;
import com.aerovistadrones.app.entities.dto.LoginDto;

@Service
public class LoginBiz {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private JwtEncoder jwtEncoder;

    public String autenticarEObterToken(LoginDto loginDto) {
        if (!logar(loginDto)) {
            return null;
        }

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("aerovista-app")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(loginDto.getLoginEmail())
                .claim("scope", "read")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private boolean logar(LoginDto loginDto) {
        if (!checkEmailExists(loginDto.getLoginEmail())) {
            return false;
        }

        String senhaBanco = loginDao.selectUserPw(loginDto.getLoginEmail());
        return verificarSenha(loginDto.getLoginSenha(), senhaBanco);
    }

    private boolean checkEmailExists(String email) {
        return loginDao.checkEmailExists(email) > 0;
    }

    private static boolean verificarSenha(String senhaForm, String senhaBd) {
        return BCrypt.checkpw(senhaForm, senhaBd);
    }
}

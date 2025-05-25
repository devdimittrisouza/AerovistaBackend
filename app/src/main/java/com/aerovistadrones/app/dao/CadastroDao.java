package com.aerovistadrones.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.aerovistadrones.app.entities.dto.CadastroDto;

import db.DB;
import db.DbException;

@Repository
public class CadastroDao {
	
	public int insertNewUsuario(CadastroDto cadDto) {
		
		int rowsAffectedd = 0;
		Connection conn = null;
	    PreparedStatement pst = null;

		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement("INSERT INTO TB_USUARIO("
					+ "USER_NOME,USER_EMAIL,USER_TEL,USER_CPF,USER_SENHA)"
					+ "VALUES(?,?,?,?,?)");
			pst.setString(1, cadDto.getCadNome());
			pst.setString(2, cadDto.getCadEmail());
			pst.setString(3, cadDto.getCadTel());
			pst.setString(4, cadDto.getCadCpf());
			pst.setString(5, cadDto.getCadSenha());
			
			rowsAffectedd = pst.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatemenet(pst);
			DB.closeConnection(conn);
		}
		return rowsAffectedd;
	}
	
	public int checkCpfExists(String cpf) {
		
		int userExists = 0;
		
		Connection conn = null;
	    PreparedStatement pst = null;
	    try {
	    	conn = DB.getConnection();
	    	pst = conn.prepareStatement("SELECT 1 FROM TB_USUARIO WHERE 1=1 AND USER_CPF = ?");
	    	pst.setString(1, cpf);
	    	
	    	ResultSet rs = pst.executeQuery();
	    	
	    	if(rs.next()) {
	    		userExists = 1;
	    	}
	    	
	    }catch(SQLException e) {
	    	throw new DbException(e.getMessage());
	    }finally {
	    	DB.closeStatemenet(pst);
			DB.closeConnection(conn);
	    }
		return userExists;
	}
	
}

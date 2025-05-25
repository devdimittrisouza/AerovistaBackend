package com.aerovistadrones.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import db.DB;
import db.DbException;

@Repository
public class LoginDao {

	public String selectUserPw(String userEmail) {
		
		Connection conn = null;
	    PreparedStatement pst = null;
	    String userPw = null;
	    
	    try {
	    	conn = DB.getConnection();
	    	pst = conn.prepareStatement("SELECT USER_SENHA FROM TB_USUARIO WHERE 1=1 AND USER_EMAIL = ?");
	    	pst.setString(1, userEmail);
	    	
	    	ResultSet rs = pst.executeQuery();
	    	if(rs.next()) {
	    		userPw = rs.getString("USER_SENHA");
	    	}
	    	return userPw;
	    	
	    }catch(SQLException e) {
	    	throw new DbException(e.getMessage());
	    }finally {
	    	DB.closeStatemenet(pst);
	    	DB.closeConnection(conn);
	    }
	}
	
public int checkEmailExists(String email) {
		
		int userExists = 0;
		
		Connection conn = null;
	    PreparedStatement pst = null;
	    try {
	    	conn = DB.getConnection();
	    	pst = conn.prepareStatement("SELECT 1 FROM TB_USUARIO WHERE 1=1 AND USER_EMAIL = ?");
	    	pst.setString(1, email);
	    	
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

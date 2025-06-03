package com.aerovistadrones.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aerovistadrones.app.entities.dto.OrcamentoDto;

import db.DB;
import db.DbException;

@Repository
public class OrcamentoDao {

	public int getUserIdByEmail(String email) {
		
		Connection conn = null;
	    PreparedStatement pst = null;
	    Integer userId = null;
	    
	    try {
	    	conn = DB.getConnection();
	    	pst = conn.prepareStatement("SELECT USER_ID FROM TB_USUARIO WHERE 1=1 AND USER_EMAIL = ?");
	    	pst.setString(1, email);
	    	
	    	ResultSet rs = pst.executeQuery();
	    	if(rs.next()) {
	    		userId = rs.getInt("USER_ID");
	    	}
	    	
	    }catch(SQLException e) {
	    	throw new DbException(e.getMessage());
	    }finally {
	    	DB.closeStatemenet(pst);
	    	DB.closeConnection(conn);
	    }
	    return userId;
	}
	
	public int insertOrcamento(OrcamentoDto orcDto) {
		
		int rowsAffected = 0;
		Connection conn = null;
	    PreparedStatement pst = null;
	    try {
	    	conn = DB.getConnection();
	    	pst = conn.prepareStatement("INSERT INTO TB_ORCAMENTO(ORC_TIPO_EVENTO,ORC_DATA_INICIO,ORC_DATA_FIM,ORC_COMPLEMENTARES,USER_ID)"
	    			+ "VALUES(?,?,?,?,?)");
	    	pst.setString(1, orcDto.getOrcTipoEvento());
	    	pst.setTimestamp(2, Timestamp.valueOf(orcDto.getOrcDataInicio()));
	    	pst.setTimestamp(3, Timestamp.valueOf(orcDto.getOrcDataFim()));
	    	pst.setString(4, orcDto.getOrcComplementares());
	    	pst.setInt(5, orcDto.getFkUserId());
	    	
	    	rowsAffected = pst.executeUpdate(); 
	    	
	    }catch(SQLException e) {
	    	throw new DbException(e.getMessage());
	    }finally {
	    	DB.closeStatemenet(pst);
	    	DB.closeConnection(conn);
	    }
	    return rowsAffected;
	}
	
	public List<OrcamentoDto> getOrcamentosByUserId(int userId) {
	    List<OrcamentoDto> lista = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pst = null;

	    try {
	        conn = DB.getConnection();
	        pst = conn.prepareStatement("SELECT ORC_TIPO_EVENTO, ORC_DATA_INICIO, ORC_DATA_FIM, ORC_COMPLEMENTARES FROM TB_ORCAMENTO WHERE USER_ID = ?");
	        pst.setInt(1, userId);

	        ResultSet rs = pst.executeQuery();

	        while(rs.next()) {
	            OrcamentoDto dto = new OrcamentoDto();
	            dto.setOrcTipoEvento(rs.getString("ORC_TIPO_EVENTO"));
	            dto.setOrcDataInicio(rs.getTimestamp("ORC_DATA_INICIO").toLocalDateTime());
	            dto.setOrcDataFim(rs.getTimestamp("ORC_DATA_FIM").toLocalDateTime());
	            dto.setOrcComplementares(rs.getString("ORC_COMPLEMENTARES"));
	            // fkUserId não precisa setar aqui se não usar no front
	            lista.add(dto);
	        }

	    } catch(SQLException e) {
	        throw new DbException(e.getMessage());
	    } finally {
	        DB.closeStatemenet(pst);
	        DB.closeConnection(conn);
	    }
	    return lista;
	}
}

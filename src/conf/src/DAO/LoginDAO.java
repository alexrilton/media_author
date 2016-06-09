/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Login;
import darethink.database_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marce
 */
public class LoginDAO {
    private final Connection connection;

	  public LoginDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
            this.connection = new database_connection().conectar();
	  }
          
	  public Login checaLogin(String username,String password){
		  Login login = null;
		   try {
			   String sql = "SELECT * FROM TCC.CADASTRO WHERE login=? and senha=?";
			   PreparedStatement stmt = connection.prepareStatement(sql);
		        // prepared statement para inserção
			   stmt.setString(1, username);  
			   stmt.setString(2, password);  
			  
		       ResultSet rs = stmt.executeQuery();  
		       if (rs.next()) { 
		    	   login = new Login();
		    	   login.setUserId(rs.getString("ID_CADASTRO"));
		    	   login.setFlag_admin(rs.getInt("FLAG_ADM"));
		    	   login.setUsername(rs.getString("LOGIN"));
		    	   login.setPassword(rs.getString("SENHA"));
		    	   
		          }  
		        
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
		return login;
	}
	  
	  public void criarLogin(String username,String password,Integer flag_admin){
		
		   try {
			   String sql = "INSERT INTO TCC.CADASTRO (LOGIN,SENHA,FLAG_ADM) VALUES(?,?,?)";
			   PreparedStatement stmt = connection.prepareStatement(sql);
		        // prepared statement para inserção
			   stmt.setString(1, username);  
			   stmt.setString(2, password); 
			   stmt.setInt(3, flag_admin);  
		       stmt.execute();
		       stmt.close();
		        
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
		
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import DAO.LoginDAO;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author marce
 */
public class Login{
    String ret = "ERROR";  
    String username;
    String password;
    Integer flag_admin;
	
    String userId;
	
	
	public String execute() {
            try {
		LoginDAO login = new LoginDAO();
		Login res = login.checaLogin(username, password);
		Map session = (Map) ActionContext.getContext().get("session");
		   session.put("myuserSession", res.getUsername());
		   session.put("mycredentialsSession", res.getFlag_admin());
		   ret= "SUCCESS";
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        // TODO Auto-generated catch block
        // TODO Auto-generated catch block
         catch (SQLException e1) {
                    addActionError(getText("error.login"));    
                    ret = "ERROR";
                    e1.printStackTrace();
                }
		
		return ret;
	}
	
	public String redirecionaLogin(){
		return "success";
	}
        
	public String criaLogin() {
		
		try {
			LoginDAO login=new LoginDAO();
			login.criarLogin(username, password, flag_admin);
			
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
        // TODO Auto-generated catch block
        // TODO Auto-generated catch block
			return "success";			
		}
        
	public Integer getFlag_admin() {
		return flag_admin;
	}
        
	public void setFlag_admin(Integer flag_admin) {
		this.flag_admin = flag_admin;
	}
        
	public String getUsername() {
		return username;
	}
        
	public void setUsername(String username) {
		this.username = username;
	}
        
	public String getPassword() {
		return password;
	}
        
	public void setPassword(String password) {
		this.password = password;
	}
        
	public String getUserId() {
		return userId;
	}
        
	public void setUserId(String userId) {
		this.userId = userId;
	}
        
}

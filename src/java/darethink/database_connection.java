/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darethink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author marce
 */
public class database_connection {
    //private String driver ="com.mysql.jdbc.Driver";
    //private String url = "jdbc:mysql://localhost:3306/author_media";
    
    public Statement stm;
    public ResultSet rs;
    
    public Connection conectar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        //Class.forName(driver);
        //Connection con = DriverManager.getConnection(url, usuario, senha);
        
        //final String driver ="com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://127.0.0.1:3306/author_media";
	Properties connectProperties = new Properties();
	connectProperties.put("user", "root");//user com permissao grant all
	connectProperties.put("password", "");
	Connection connection = null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//obtendo a conexao
		 connection = DriverManager.getConnection(url,connectProperties);
//		System.out.println("connected");
                stm = connection.createStatement();
	}
            catch (SQLException e){
		throw e;
            }
            return connection;
    }
        
}

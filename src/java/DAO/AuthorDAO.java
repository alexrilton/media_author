/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Author;
import Entities.Country;
import darethink.database_connection;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class AuthorDAO extends database_connection{
    Author a = new Author();
    String sql;
    
    public AuthorDAO() throws Exception{
        Connection conectar = conectar();
    }
    
    public Author getAuthor(String nameAuthor) throws Exception{
        sql = "SELECT * FROM `author`, `country` WHERE `author`.`NAME_AUTHOR` LIKE" + nameAuthor + "AND `author`.`ID_COUNTRY` = `country`.`ID_COUNTRY`";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry((Country) rs.getObject(3));
        }
        return a;
    }
    
    public int getAuthorId(String nameAuthor) throws Exception{
        sql = "SELECT * FROM author WHERE NAME_AUTHOR = '" + nameAuthor+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            a.setIdAuthor(rs.getInt(1));
        }
        id = a.getIdAuthor();
        return id;
    }
    
    public List<Author> listaAuthor() throws Exception{
        List <Author> listaAuthor = new LinkedList();
        sql = "SELECT * FROM author as a, country as c WHERE a.ID_COUNTRY = c.ID_COUNTRY";
        rs = stm.executeQuery(sql);
        CountryDAO daoc = new CountryDAO();
        while (rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry(daoc.getCountrybyID(rs.getInt(3)));
            listaAuthor.add(a);
        }
        return listaAuthor;
    }
    
    public void insertAuthor(String nameAuthor, int idCountry) throws Exception{
        sql = "INSERT INTO author (NAME_AUTHOR, ID_COUNTRY) VALUES (UPPER('" +nameAuthor+  "')," +idCountry+  ")";
        stm.executeUpdate(sql);
    }
    
    public void changeAuthor(String nameAuthorNew, String nameAuthor) throws Exception{
        sql = "UPDATE `author` SET NAME_AUTHOR = ? WHERE (SELECT * FROM `author` WHERE UPPER(`author`.`NAME_AUTHOR`) = UPPER(?))";
        stm.executeUpdate(sql);
    }
    
    public void deleteAuthorName(String nameAuthor) throws Exception{
        sql = "DELETE FROM `author` WHERE `author`.`NAME_AUTHOR` LIKE" + nameAuthor;
        stm.executeUpdate(sql);
    }
    
    public void deleteAuthorId(String idAuthor) throws Exception{
        sql = "DELETE FROM `author` WHERE `author`.`ID_AUTHOR` = " + idAuthor;
        stm.executeUpdate(sql);
    }
}

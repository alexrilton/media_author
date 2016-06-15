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
    
    public Author getAuthorId(Integer idAuthor) throws Exception{
        sql = "SELECT * FROM `author` WHERE `author`.`ID_AUTHOR` = " + idAuthor;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry((Country) rs.getObject(3));
        }
        return a;
    }
    
    public List<Author> listaAuthor() throws Exception{
        List <Author> listaAuthor = new LinkedList();
        sql = "SELECT `* FROM `author`, `country` WHERE `author`.`ID_COUNTRY` = `country`.`ID_COUNTRY`";
        rs = stm.executeQuery(sql);
        while (rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry((Country) rs.getObject(3));
            listaAuthor.add(a);
        }
        return listaAuthor;
    }
    
    public void insertAuthor(String nameAuthor, String nameCountry) throws Exception{
        sql = "INSERT INTO `author`(ID_AUTHOR, NAME_AUTHOR, ID_COUNTRY) VALUES(?,?,(SELECT `country`.`ID_COUNTRY` FROM `country` WHERE UPPER(`country`.`NAME_COUNTRY`) = UPPER(?)))";
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

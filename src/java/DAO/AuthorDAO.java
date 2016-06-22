/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Author;
import Entities.Country;
import darethink.database_connection;
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
    }
    
    public Author getAuthor(String nameAuthor) throws Exception{
        this.conectar();
        sql = "SELECT * FROM `author`, `country` WHERE `author`.`NAME_AUTHOR` LIKE" + nameAuthor + "AND `author`.`ID_COUNTRY` = `country`.`ID_COUNTRY`";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry((Country) rs.getObject(3));
        }
        this.connection.close();
        return a;
    }
    
    public int getAuthorId(String nameAuthor) throws Exception{
        this.conectar();
        sql = "SELECT * FROM author WHERE NAME_AUTHOR = '" + nameAuthor+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            a.setIdAuthor(rs.getInt(1));
        }
        id = a.getIdAuthor();
        this.connection.close();
        return id;
    }
    
    public List<Author> listaAuthor() throws Exception{
        this.conectar();
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
        this.connection.close();
        return listaAuthor;
    }
    
    public List<Author> listaAuthorRef() throws Exception{
        this.conectar();
        List <Author> listaAuthor = new LinkedList();
        sql = "SELECT * FROM author WHERE ID_AUTHOR NOT IN (SELECT ID_AUTHOR FROM author_speciality)";
        rs = stm.executeQuery(sql);
        CountryDAO daoc = new CountryDAO();
        while (rs.next()){
            a = new Author();
            a.setIdAuthor(rs.getInt(1));
            a.setNameAuthor(rs.getString(2));
            a.setCountry(daoc.getCountrybyID(rs.getInt(3)));
            listaAuthor.add(a);
        }
        this.connection.close();
        return listaAuthor;
    }
    
    public void insertAuthor(String nameAuthor, int idCountry) throws Exception{
        this.conectar();
        sql = "INSERT INTO author (NAME_AUTHOR, ID_COUNTRY) VALUES (UPPER('" +nameAuthor+  "')," +idCountry+  ")";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void updateAuthor(String nameAuthorOld, String nameAuthor, int idCountry) throws Exception{
        this.conectar();
        sql = "UPDATE `author` SET NAME_AUTHOR = (UPPER('"+nameAuthor+"')), ID_COUNTRY = " +idCountry+" WHERE `author`.`NAME_AUTHOR` =(UPPER('"+nameAuthorOld+"'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteAuthorName(String nameAuthor) throws Exception{
        this.conectar();
        sql = "DELETE FROM `author` WHERE `author`.`NAME_AUTHOR` ='" + nameAuthor+"'";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteAuthorId(String idAuthor) throws Exception{
        this.conectar();
        sql = "DELETE FROM `author` WHERE `author`.`ID_AUTHOR` = " + idAuthor;
        stm.executeUpdate(sql);
        this.connection.close();
    }
}

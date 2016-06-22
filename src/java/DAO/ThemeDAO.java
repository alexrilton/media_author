/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Theme;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class ThemeDAO extends database_connection{
    Theme t = new Theme();
    String sql;
    
    public ThemeDAO() throws Exception{
    }
    
    public Theme getThemeName(String nameTheme) throws Exception{
        this.conectar();
        sql = "SELECT * FROM theme WHERE UPPER(NAME_THEME) LIKE UPPER('" +nameTheme+  "')";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
            //st.setSpec((Speciality) rs.getObject(3));
        }
        this.connection.close();
        return t;
    }
    
    public Theme getThemebyId(Integer idTheme) throws Exception{
        this.conectar();
        sql = "SELECT * FROM theme WHERE ID_THEME = " + idTheme;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
        }
        this.connection.close();
        return t;
    }
       
    public int getThemeId(String nameTheme) throws Exception{
        this.conectar();
        sql = "SELECT ID_THEME FROM theme WHERE NAME_THEME ='" +nameTheme+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            //st.setSpec((Speciality) rs.getObject(3));
        }
        id = t.getIdTheme();
        this.connection.close();
        return id;
    }
    
    public List<Theme> listaTheme() throws Exception{
        this.conectar();
        List<Theme> listaTheme = new LinkedList();
        sql = "SELECT * FROM `theme`";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            t = new Theme();
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
            //st.setSpec((Speciality) rs.getObject(3));
            listaTheme.add(t);
        }
        this.connection.close();
        return listaTheme;
    }
    
    public List<Theme> listaThemeRef() throws Exception{
        this.conectar();
        List<Theme> listaTheme = new LinkedList();
        sql = "SELECT * FROM theme WHERE ID_THEME NOT IN (SELECT ID_THEME FROM speciality)";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            t = new Theme();
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
            //st.setSpec((Speciality) rs.getObject(3));
            listaTheme.add(t);
        }
        this.connection.close();
        return listaTheme;
    }
    
    public void insertTheme(String nameTheme) throws Exception{
        this.conectar();
        sql = "INSERT INTO theme (NAME_THEME) VALUES(UPPER ('" +nameTheme+  "'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void updateTheme(String nameThemeOld, String nameTheme) throws Exception{
        this.conectar();
        sql = "UPDATE `theme` SET NAME_THEME = (UPPER('"+nameTheme+"')) WHERE `theme`.`NAME_THEME` =(UPPER('"+nameThemeOld+"'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteThemeName(String nameTheme) throws Exception{
        this.conectar();
        sql = "DELETE FROM `theme` WHERE `theme`.`NAME_THEME` ='" + nameTheme+"'";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteThemeId(Integer idTheme) throws Exception{
        this.conectar();
        sql = "DELETE FROM `theme` WHERE `theme`.`NAME_THEME` LIKE " + idTheme;
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
}

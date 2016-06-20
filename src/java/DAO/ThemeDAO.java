/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Theme;
import darethink.database_connection;
import java.sql.Connection;
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
        conectar();
    }
    
    public Theme getThemeName(String nameTheme) throws Exception{
        sql = "SELECT * FROM theme WHERE UPPER(NAME_THEME) LIKE UPPER('" +nameTheme+  "')";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
            //st.setSpec((Speciality) rs.getObject(3));
        }
        return t;
    }
    
    public Theme getThemebyId(Integer idTheme) throws Exception{
        sql = "SELECT * FROM theme WHERE ID_THEME = " + idTheme;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            t.setNameTheme(rs.getString(2));
        }
        return t;
    }
       
    public int getThemeId(String nameTheme) throws Exception{
        sql = "SELECT ID_THEME FROM theme WHERE NAME_THEME ='" +nameTheme+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            t.setIdTheme(rs.getInt(1));
            //st.setSpec((Speciality) rs.getObject(3));
        }
        id = t.getIdTheme();
        return id;
    }
    
    public List<Theme> listaTheme() throws Exception{
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
        return listaTheme;
    }
    
    public void insertTheme(String nameTheme) throws Exception{
        sql = "INSERT INTO theme (NAME_THEME) VALUES(UPPER ('" +nameTheme+  "'))";
        stm.executeUpdate(sql);
    }
    
    public void changeTheme(String nameTheme) throws Exception{
        sql = "UPDATE `theme` SET NAME_THEME = ? WHERE (SELECT * FROM `specific_theme` WHERE UPPER(`specific_theme`.`NAME_THEME`) = UPPER(?))";
        stm.executeUpdate(sql);
    }
    
    public void deleteThemeName(String nameTheme) throws Exception{
        sql = "DELETE FROM `theme` WHERE `theme`.`NAME_THEME` LIKE " + nameTheme;
        stm.executeUpdate(sql);
    }
    
    public void deleteThemeId(Integer idTheme) throws Exception{
        sql = "DELETE FROM `theme` WHERE `theme`.`NAME_THEME` LIKE " + idTheme;
        stm.executeUpdate(sql);
    }
    
}

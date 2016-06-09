/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Speciality;
import Entities.SpecificTheme;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class SpecificThemeDAO extends database_connection{
    SpecificTheme st = new SpecificTheme();
    String sql;
    
    public SpecificThemeDAO() throws Exception{
        conectar();
    }
    
    public SpecificTheme getSpecificThemeName(String nameTheme) throws Exception{
        sql = "SELECT * FROM `specific_theme` WHERE `specific_theme`.`NAME_THEME` LIKE " + nameTheme;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            st.setIdTheme(rs.getInt(1));
            st.setNameTheme(rs.getString(2));
            st.setSpec((Speciality) rs.getObject(3));
        }
        return st;
    }
    
    public SpecificTheme getSpecificThemeId(Integer idTheme) throws Exception{
        sql = "SELECT * FROM `specific_theme` WHERE `specific_theme`.`ID_THEME` = " + idTheme;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            st.setIdTheme(rs.getInt(1));
            st.setNameTheme(rs.getString(2));
            st.setSpec((Speciality) rs.getObject(3));
        }
        return st;
    }
    
    public List<SpecificTheme> listaSpecificTheme() throws Exception{
        List<SpecificTheme> listaTheme = new LinkedList();
        sql = "SELECT * FROM `specific_theme`";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            st = new SpecificTheme();
            st.setIdTheme(rs.getInt(1));
            st.setNameTheme(rs.getString(2));
            st.setSpec((Speciality) rs.getObject(3));
            listaTheme.add(st);
        }
        return listaTheme;
    }
    
    public void insertSpecificTheme(String nameTheme, String nameSpec) throws Exception{
        sql = "INSERT INTO `specific_theme`(ID_THEME, NAME_THEME, ID_SPEC) VALUES(,?,(SELECT `speciality`.`ID_SPEC` FROM `speciality` WHERE UPPER(`speciality`.`NAME_SPEC`) = UPPER(?)))";
        stm.executeUpdate(sql);
    }
    
    public void changeSpecificTheme(String nameTheme) throws Exception{
        sql = "UPDATE `specific_theme` SET NAME_THEME = ? WHERE (SELECT * FROM `specific_theme` WHERE UPPER(`specific_theme`.`NAME_THEME`) = UPPER(?))";
        stm.executeUpdate(sql);
    }
    
    public void deleteSpecificThemeName(String nameTheme) throws Exception{
        sql = "DELETE FROM `specific_theme` WHERE `specific_theme`.`NAME_THEME` LIKE " + nameTheme;
        stm.executeUpdate(sql);
    }
    
    public void deleteSpecificThemeId(Integer idTheme) throws Exception{
        sql = "DELETE FROM `specific_theme` WHERE `specific_theme`.`NAME_THEME` LIKE " + idTheme;
        stm.executeUpdate(sql);
    }
    
}

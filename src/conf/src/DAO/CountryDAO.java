/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Country;
import Entities.Region;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class CountryDAO extends database_connection{
    Country c = new Country();
    String sql;
    
    public CountryDAO() throws Exception{
        conectar();
    }
    
    public Country getCountryName(String nameCountry) throws Exception{
        sql = "SELECT * FROM  `country` WHERE `country`.`NAME_COUNTRY` LIKE " + nameCountry;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion((Region) rs.getObject(3));
        }
        return c;
    }
    
    public Country getCountryId(Integer idCountry) throws Exception{
        sql = "SELECT * FROM  `country` WHERE `country`.`ID_COUNTRY` = " + idCountry;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion((Region) rs.getObject(3));
        }
        return c;
    }
    
    public List<Country> listaCountry() throws Exception{
        List<Country> listaCountry = new LinkedList();
        sql = "SELECT * FROM  `country`";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            c = new Country();
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion((Region) rs.getObject(3));
            listaCountry.add(c);
        }
        return listaCountry;
    }
    
    public void insertCountry(String nameCountry, String nameRegion) throws Exception{
        sql = "INSERT INTO `country`(ID_COUNTRY, NAME_COUNTRY, NAME_REGION) VALUES(?,?,(SELECT `region`.`ID_REGION` FROM `region` WHERE UPPER(`region`.`NAME_REGION`) = UPPER(?)))";
        stm.executeUpdate(sql);
    }
    
    public void changeCountryName(String nameCountryNew, String nameCountry) throws Exception{
        sql = "UPDATE `country` SET NAME_COUNTRY = ? WHERE (SELECT * FROM `country` WHERE UPPER(`country`.`NAME_COUNTRY`) = UPPER(?))";
        stm.executeUpdate(sql);
    }
    
    public void deleteCountryName(String nameCountry) throws Exception{
        sql = "DELETE FROM `country` WHERE `country`.`NAME_COUNTRY` LIKE " + nameCountry;
        stm.executeUpdate(sql);
    }
    
    public void deleteCountryId(Integer idCountry) throws Exception{
        sql = "DELETE FROM `country` WHERE `country`.`ID_COUNTRY` " + idCountry;
        stm.executeUpdate(sql);
    }
    
}

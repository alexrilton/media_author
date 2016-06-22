/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Country;
import Entities.Region;
import darethink.database_connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class CountryDAO extends database_connection{
    Country c = new Country();
    String sql;
    
    public CountryDAO() throws Exception{
    }
    
    public Country getCountryName(String nameCountry) throws Exception{
        this.conectar();
        sql = "SELECT * FROM  `country` WHERE `country`.`NAME_COUNTRY` LIKE " + nameCountry;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion((Region) rs.getObject(3));
        }
        this.connection.close();
        return c;
    }
    
    public int getCountryId(String nameCountry) throws Exception{
        this.conectar();
        sql = "SELECT * FROM  country WHERE NAME_COUNTRY ='" + nameCountry+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            c.setIdCountry(rs.getInt(1));
        }
        id = c.getIdCountry();
        this.connection.close();
        return id;
    }
    
    public Country getCountrybyID(Integer idCountry) throws Exception{
        this.conectar();
        sql = "SELECT  * FROM country WHERE ID_COUNTRY = " + idCountry;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
        }
        this.connection.close();
        return c;
    }
    
    
    public List<Country> listaCountry() throws Exception{
        this.conectar();
        List<Country> listaCountry = new ArrayList();
        sql = "SELECT * FROM  country";
        rs = stm.executeQuery(sql);
        RegionDAO daor = new RegionDAO();        
        while(rs.next()){
            c = new Country();
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion(daor.getRegionbyID(rs.getInt(3)));
            listaCountry.add(c);
        }
        this.connection.close();
        return listaCountry;
    }
    
    public List<Country> listaCountry(int idRegion) throws Exception{
        this.conectar();
        List<Country> listaCountry = new ArrayList();
        sql = "select * from country where ID_REGION =" + idRegion;
        rs = stm.executeQuery(sql);
        RegionDAO daor = new RegionDAO();
        while(rs.next()){
            c = new Country();
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion(daor.getRegionbyID(rs.getInt(3)));
            listaCountry.add(c);
        }
        this.connection.close();
        return listaCountry;
    }
    
    public List<Country> listaCountryByMedia(String nameMedia) throws Exception{
        this.conectar();
        List<Country> listaCountry = new ArrayList();
        sql = "SELECT c.ID_COUNTRY, c.NAME_COUNTRY, c.ID_REGION FROM country c, media m WHERE m.NAME_MEDIA = '" + nameMedia + "'AND m.ID_COUNTRY = c.ID_COUNTRY";
        rs = stm.executeQuery(sql);
        RegionDAO daor = new RegionDAO();
        while(rs.next()){
            c = new Country();
            c.setIdCountry(rs.getInt(1));
            c.setNameCountry(rs.getString(2));
            c.setRegion(daor.getRegionbyID(rs.getInt(3)));
            listaCountry.add(c);
        }
        this.connection.close();
        return listaCountry;
    }
    
    public void insertCountry(String nameCountry, int idRegion) throws Exception{
        this.conectar();
        sql = "INSERT INTO country (NAME_COUNTRY, ID_REGION) VALUES (UPPER('" +nameCountry+  "')," +idRegion+  ")";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void updateCountry(String nameCountryOld, String nameCountry, int idRegion) throws Exception{
        this.conectar();
        sql = "UPDATE `country` SET NAME_COUNTRY = (UPPER('"+nameCountry+"')), ID_REGION = " +idRegion+" WHERE `country`.`NAME_COUNTRY` =(UPPER('"+nameCountryOld+"'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteCountryName(String nameCountry) throws Exception{
        this.conectar();
        sql = "DELETE FROM `country` WHERE `country`.`NAME_COUNTRY` ='" + nameCountry+"'";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteCountryId(Integer idCountry) throws Exception{
        this.conectar();
        sql = "DELETE FROM `country` WHERE `country`.`ID_COUNTRY` " + idCountry;
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Country;
import Entities.Media;
import darethink.database_connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class MediaDAO extends database_connection{
    Media m = new Media();
    String sql;
    
    public MediaDAO() throws Exception{
    }
    
    public Media getMediaName(String nameMedia) throws Exception{
        this.conectar();
        sql = "SELECT * FROM `media` WHERE `media`.`NAME_MEDIA` LIKE " + nameMedia;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry((Country) rs.getObject(3));
        }
        this.connection.close();
        return m;
    }
    
    public int getMediaId(String nameMedia) throws Exception{
        this.conectar();
        sql = "SELECT * FROM media WHERE NAME_MEDIA ='" + nameMedia+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            m.setIdMedia(rs.getInt(1));
        }
        id = m.getIdMedia();
        this.connection.close();
        return id;
    }
       
    public List<Media> listaMedia() throws Exception{
        this.conectar();
        List<Media> listaMedia = new ArrayList();
        sql = "SELECT * FROM media GROUP BY NAME_MEDIA";
        rs = stm.executeQuery(sql);
        CountryDAO daoc = new CountryDAO();
        while(rs.next()){
            m = new Media();
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry(daoc.getCountrybyID(rs.getInt(3)));
            listaMedia.add(m);
        }
        this.connection.close();
        return listaMedia;
    }
    
    public List<Media> listaMediaByCountry(String nameCountry) throws Exception{
        this.conectar();
        List<Media> listaMedia = new ArrayList();
        sql = "SELECT m.ID_MEDIA, m.NAME_MEDIA, m.ID_COUNTRY FROM country c, media m WHERE c.NAME_COUNTRY = '" + nameCountry + "'AND c.ID_COUNTRY = m.ID_COUNTRY";
        rs = stm.executeQuery(sql);
        CountryDAO daoc = new CountryDAO();
        while(rs.next()){
            m = new Media();
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry(daoc.getCountrybyID(rs.getInt(3)));
            listaMedia.add(m);
        }
        this.connection.close();
        return listaMedia;
    }
    
    public void insertMedia(String nameMedia, int idCountry) throws Exception{
        this.conectar();
        sql = "INSERT INTO media (NAME_MEDIA, ID_COUNTRY) VALUES (UPPER('" +nameMedia+  "')," +idCountry+  ")";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void updateMedia(String nameMediaOld, String nameMedia, int idCountry) throws Exception{
        this.conectar();
        sql = "UPDATE `media` SET NAME_MEDIA = (UPPER('"+nameMedia+"')), ID_COUNTRY = " +idCountry+" WHERE `media`.`NAME_MEDIA` =(UPPER('"+nameMediaOld+"'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteMediaName(String nameMedia) throws Exception{
        this.conectar();
        sql = "DELETE FROM `media` WHERE `media`.`NAME_MEDIA` ='" + nameMedia+"'";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteMediaId(Integer idMedia) throws Exception{
        this.conectar();
        sql = "DELETE FROM `media` WHERE `media`.`ID_MEDIA` = " + idMedia;
        stm.executeUpdate(sql);
        this.connection.close();
    }
}

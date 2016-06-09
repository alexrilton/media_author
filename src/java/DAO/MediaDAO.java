/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Country;
import Entities.Media;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class MediaDAO extends database_connection{
    Media m = new Media();
    String sql;
    
    public MediaDAO() throws Exception{
        conectar();
    }
    
    public Media getMediaName(String nameMedia) throws Exception{
        sql = "SELECT * FROM `media` WHERE `media`.`NAME_MEDIA` LIKE " + nameMedia;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry((Country) rs.getObject(3));
        }
        return m;
    }
    
    public Media getMediaId(Integer idMedia) throws Exception{
        sql = "SELECT * FROM `media` WHERE `media`.`ID_MEDIA` = " + idMedia;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry((Country) rs.getObject(3));
        }
        return m;
    }
    
    public List<Media> listaMedia() throws Exception{
        List<Media> listaMedia = new LinkedList();
        sql = "SELECT * FROM `media`";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            m = new Media();
            m.setIdMedia(rs.getInt(1));
            m.setNameMedia(rs.getString(2));
            m.setCountry((Country) rs.getObject(3));
            listaMedia.add(m);
        }
        return listaMedia;
    }
    
    public void insertMedia(String nameMedia, int idCountry) throws Exception{
        sql = "INSERT INTO media (NAME_MEDIA, ID_COUNTRY) VALUES (UPPER('" +nameMedia+  "')," +idCountry+  ")";
        stm.executeUpdate(sql);
    }
    
    public void changeMedia(String nameMedia) throws Exception{
        sql = "UPDATE `media` SET NAME_MEDIA = ? WHERE (SELECT * FROM `media` WHERE UPPER(`media`.`NAME_MEDIA`) = UPPER(?))";
        stm.executeUpdate(sql);
    }
    
    public void deleteMediaName(String nameMedia) throws Exception{
        sql = "DELETE FROM `media` WHERE `media`.`NAME_MEDIA` LIKE " + nameMedia;
        stm.executeUpdate(sql);
    }
    
    public void deleteMediaId(Integer idMedia) throws Exception{
        sql = "DELETE FROM `media` WHERE `media`.`ID_MEDIA` = " + idMedia;
        stm.executeUpdate(sql);
    }
}

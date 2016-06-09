/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Region;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class RegionDAO extends database_connection{
    Region r = new Region();
    String sql;
    
    public RegionDAO() throws Exception{
        conectar();
    }
    
    public Region getRegion(String nameRegion) throws Exception{
        sql = "SELECT * FROM `region` WHERE `region`.`NAME_REGION` LIKE " + nameRegion;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        return r;
    }
    
    public Region getRegionId(Integer idRegion) throws Exception{
        sql = "SELECT  * FROM `region` WHERE `region`.`ID_REGION` = " + idRegion;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        return r;
    }
    
    public List<Region> listaRegion() throws Exception{
        List<Region> listaRegion = new LinkedList();
        sql = "SELECT  * FROM  `region`";
        rs = stm.executeQuery(sql);
        while (rs.next()){
            r = new Region();
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
            listaRegion.add(r);
        }
        return listaRegion;
    }
    
    public void insertRegion(String nameRegion) throws Exception{
        sql = "INSERT INTO `region`.`NAME_REGION` values (?) ";
        stm.executeUpdate(sql);
    }
    
    public void changeRegionName(String nameRegion, String nameRegion2) throws Exception{
        sql = "SELECT * FROM `region` WHERE `region`.`NAME_REGION` LIKE " + nameRegion;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        sql = "UPDATE `region` SET idRegion = " + r.getIdRegion() + ", nameRegion = " + nameRegion2 + "WHERE idRegion = " + r.getIdRegion();
        stm.executeUpdate(sql);
    }
    
    public void deleteRegionName(String nameRegion) throws Exception{
        sql = "DELETE FROM `region` WHERE `region`.`NAME_REGION` LIKE " + nameRegion;
        stm.executeUpdate(sql);
    }
    
    public void deleteRegionId(Integer idRegion) throws Exception{
        sql = "DELETE FROM `region` WHERE `region`.`ID_REGION` = " + idRegion;
        stm.executeUpdate(sql);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Speciality;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class SpecialityDAO extends database_connection{
    Speciality spec = new Speciality();
    String sql;
    
    public SpecialityDAO() throws Exception{
        conectar();
    }
    
    public Speciality getSpecialityName(String nameSpec) throws Exception{
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`NAME_SPEC` LIKE " + nameSpec;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            spec.setIdSpec(rs.getInt(1));
            spec.setNameSpec(rs.getString(2));
        }
        return spec;
    }
    
    public Speciality getSpecialityId(Integer idSpec) throws Exception{
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_SPEC` = " + idSpec;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            spec.setIdSpec(rs.getInt(1));
            spec.setNameSpec(rs.getString(2));
        }
        return spec;
    }
    
    public List<Speciality> listaSpeciality() throws Exception{
        List <Speciality> listaSpeciality = new LinkedList();
        sql = "SELECT * FROM `speciality`";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            spec = new Speciality();
            spec.setIdSpec(rs.getInt(1));
            spec.setNameSpec(rs.getNString(2));
            listaSpeciality.add(spec);
        }
        return listaSpeciality;
    }
    
    public void insertSpeciality(String nameSpec) throws Exception{
        sql = "INSERT INTO `speciality`(nameSpec)" + "values(" + spec.getNameSpec() + ")";
        stm.executeUpdate(sql);
    }
    
    public void changeSpeciality(String nameSpec, String nameSpec2) throws Exception{
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`NAME_SPEC` LIKE " + nameSpec;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            spec.setIdSpec(rs.getInt(1));
            spec.setNameSpec(rs.getString(2));
        }
        sql = "UPDATE `speciality` SET idSpec = " + spec.getIdSpec() + ", nameSpec = " + nameSpec2 + "WHERE idSpec = " + spec.getIdSpec();
        stm.executeUpdate(sql);
    }
    
    public void deleteSpecialityName(String nameSpec) throws Exception{
        sql = "DELETE FROM `speciality` WHERE `speciality`.`NAME_SPEC` LIKE " + nameSpec;
        stm.executeUpdate(sql);
    }
    
    public void deleteSpecialityId(Integer idSpec) throws Exception{
        sql = "DELETE FROM `speciality` WHERE `speciality`.`ID_SPEC` = " + idSpec;
        stm.executeUpdate(sql);
    }
    
}

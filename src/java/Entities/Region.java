/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author marce
 */
public class Region implements Serializable{
    public int idRegion;
    public String nameRegion;

    public Region() {
    }
    
    public Region(int idRegion, String nameRegion) {
        this.idRegion = idRegion;
        this.nameRegion = nameRegion;
    }

    public Region(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.nameRegion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Region other = (Region) obj;
        if (!Objects.equals(this.nameRegion, other.nameRegion)) {
            return false;
        }
        return true;
    }
    
    
    
}

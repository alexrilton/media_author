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
public class Speciality implements Serializable{
    private int idSpec;
    private String nameSpec;

    public Speciality() {
    }

    public Speciality(int idSpec, String nameSpec) {
        this.idSpec = idSpec;
        this.nameSpec = nameSpec;
    }

    public Speciality(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nameSpec);
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
        final Speciality other = (Speciality) obj;
        if (!Objects.equals(this.nameSpec, other.nameSpec)) {
            return false;
        }
        return true;
    }
    
    
}

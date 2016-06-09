/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author marce
 */
public class Country {
    private int idCountry;
    private String nameCountry;
    private Region region;

    public Country() {
    }

    public Country(int idCountry, String nameCountry, Region region) {
        this.idCountry = idCountry;
        this.nameCountry = nameCountry;
        this.region = region;
    }

    public Country(String nameCountry, Region region) {
        this.nameCountry = nameCountry;
        this.region = region;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nameCountry);
        hash = 37 * hash + Objects.hashCode(this.region);
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
        final Country other = (Country) obj;
        if (!Objects.equals(this.nameCountry, other.nameCountry)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return true;
    }
    
    
    
}

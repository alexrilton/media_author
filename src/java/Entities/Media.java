/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Country;
import java.util.Objects;

/**
 *
 * @author marce
 */
public class Media {
    private int idMedia;
    private String nameMedia;
    private Country country;

    public Media() {
    }

    public Media(int idMedia, String nameMedia, Country country) {
        this.idMedia = idMedia;
        this.nameMedia = nameMedia;
        this.country = country;
    }

    public Media(String nameMedia, Country country) {
        this.nameMedia = nameMedia;
        this.country = country;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public String getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(String nameMedia) {
        this.nameMedia = nameMedia;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nameMedia);
        hash = 71 * hash + Objects.hashCode(this.country);
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
        final Media other = (Media) obj;
        if (!Objects.equals(this.nameMedia, other.nameMedia)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }
    
}

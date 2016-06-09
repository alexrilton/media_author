/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Speciality;
import java.util.Objects;

/**
 *
 * @author marce
 */
public class SpecificTheme {
    private int idTheme;
    private String nameTheme;
    private Speciality spec;

    public SpecificTheme() {
    }

    public SpecificTheme(int idTheme, String nameTheme, Speciality spec) {
        this.idTheme = idTheme;
        this.nameTheme = nameTheme;
        this.spec = spec;
    }

    public SpecificTheme(String nameTheme, Speciality spec) {
        this.nameTheme = nameTheme;
        this.spec = spec;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public Speciality getSpec() {
        return spec;
    }

    public void setSpec(Speciality spec) {
        this.spec = spec;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nameTheme);
        hash = 79 * hash + Objects.hashCode(this.spec);
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
        final SpecificTheme other = (SpecificTheme) obj;
        if (!Objects.equals(this.nameTheme, other.nameTheme)) {
            return false;
        }
        if (!Objects.equals(this.spec, other.spec)) {
            return false;
        }
        return true;
    }
    
    
    
}

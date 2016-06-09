/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Author;
import java.util.Objects;

/**
 *
 * @author marce
 */
public class AuthorSpeciality {
    private Author author;
    private SpecificTheme theme;
    private Country country;
    private Media media;

    public AuthorSpeciality() {
    }

    public AuthorSpeciality(Author author, SpecificTheme theme, Country country, Media media) {
        this.author = author;
        this.theme = theme;
        this.country = country;
        this.media = media;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public SpecificTheme getTheme() {
        return theme;
    }

    public void setTheme(SpecificTheme theme) {
        this.theme = theme;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.author);
        hash = 59 * hash + Objects.hashCode(this.theme);
        hash = 59 * hash + Objects.hashCode(this.country);
        hash = 59 * hash + Objects.hashCode(this.media);
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
        final AuthorSpeciality other = (AuthorSpeciality) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.media, other.media)) {
            return false;
        }
        return true;
    }
    
    
    
}

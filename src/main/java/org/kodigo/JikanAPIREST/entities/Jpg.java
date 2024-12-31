package org.kodigo.JikanAPIREST.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.DTO.JpgDTO;

@Entity
@Table(name="jpg")
public class Jpg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private String smallImageUrl;
    private String largeImageUrl;

    public Jpg() {}

    public Jpg(JpgDTO jpgDTO) {
        this.imageUrl = jpgDTO.imageUrl();
        this.smallImageUrl = jpgDTO.smallImageUrl();
        this.largeImageUrl = jpgDTO.largeImageUrl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    @Override
    public String toString() {
        return "Jpg{" +
                "\tid=" + id + "\n" +
                "\timageUrl='" + imageUrl + '\'' +  "\n" +
                "\tsmallImageUrl='" + smallImageUrl + '\'' + "\n" +
                "\tlargeImageUrl='" + largeImageUrl + '\'' + "\n" +
                '}';
    }
}

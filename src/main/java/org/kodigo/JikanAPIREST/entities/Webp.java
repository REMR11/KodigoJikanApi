package org.kodigo.JikanAPIREST.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.DTO.WebpDTO;

@Entity
@Table(name = "webp")
public class Webp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private String smallImageUrl;
    private String largeImageUrl;

    public Webp(WebpDTO webpDTO) {
        this.imageUrl = webpDTO.imageUrl();
        this.smallImageUrl = webpDTO.smallImageUrl();
        this.largeImageUrl = webpDTO.largeImageUrl();
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
        return "Webp{" +
                "\tid=" + id + "\n"+
                "\timageUrl='" + imageUrl + '\'' + "\n"+
                "\tsmallImageUrl='" + smallImageUrl + '\'' + "\n"+
                "\tlargeImageUrl='" + largeImageUrl + '\'' + "\n"+
                '}';
    }
}

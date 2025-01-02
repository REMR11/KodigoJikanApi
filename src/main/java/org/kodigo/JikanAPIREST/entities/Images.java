package org.kodigo.JikanAPIREST.entities;

import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.dtos.ImagesDTO;


@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "jpg_id", referencedColumnName = "id")
    private Jpg jpg;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "webp_id", referencedColumnName = "id")
    private Webp webp;

    // Constructor por defecto
    public Images() {}

    // Constructor que recibe un DTO
    public Images(ImagesDTO imagesDTO) {
        if (imagesDTO.jpg() != null) {
            this.jpg = new Jpg(imagesDTO.jpg());
        }
        if (imagesDTO.webp() != null) {
            this.webp = new Webp(imagesDTO.webp());
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jpg getJpg() {
        return jpg;
    }

    public void setJpg(Jpg jpg) {
        this.jpg = jpg;
    }

    public Webp getWebp() {
        return webp;
    }

    public void setWebp(Webp webp) {
        this.webp = webp;
    }

    @Override
    public String toString() {
        return "Images{" +
                "\tid=" + id + "\n"+
                "\tjpg=" + jpg + "\n"+
                "\twebp=" + webp + "\n"+
                '}';
    }
}

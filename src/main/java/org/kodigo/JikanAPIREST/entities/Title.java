package org.kodigo.JikanAPIREST.entities;

import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.DTO.TitleDTO;

@Entity
@Table(name="title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String title;

    public Title(TitleDTO titleDTO) {
        this.type = titleDTO.type();
        this.title = titleDTO.title();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Title{" +
                "\tid="+id+"\n"+
                "\ttype='" + type + '\'' +"\n"+
                "\ttitle='" + title + '\'' +"\n"+
                '}';
    }
}

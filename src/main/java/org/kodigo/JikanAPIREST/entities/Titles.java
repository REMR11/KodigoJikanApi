package org.kodigo.JikanAPIREST.entities;

import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.DTO.TitleDTO;
import org.kodigo.JikanAPIREST.DTO.TitlesDTO;

import java.util.List;

@Entity
@Table(name = "titles")
public class Titles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "titles_id", referencedColumnName = "id")
    private List<Title> titles;

    public Titles(List<TitleDTO> titles) {
        this.titles = titles.stream().map(Title::new).toList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "\tid=" + id + "\n"+
                "\ttitles=" + titles +"\n"+
                '}';
    }
}

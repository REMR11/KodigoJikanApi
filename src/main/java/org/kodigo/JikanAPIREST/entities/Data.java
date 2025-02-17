package org.kodigo.JikanAPIREST.entities;

import jakarta.persistence.*;
import org.kodigo.JikanAPIREST.dtos.DataDTO;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private String title;
    private String titleEnglish;
    private String titleJapanese;
    private String type;
    private String source;
    private Integer episodes;
    private String status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "images_id", referencedColumnName = "id")
    private Images images;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "titles_id", referencedColumnName = "id")
    private Titles titles;

    // Constructor por defecto
    public Data() {
    }

    public Data(DataDTO dataDTO) {
        this.url = dataDTO.url();
        this.images = new Images(dataDTO.images());
        this.title = dataDTO.title();
        this.titleEnglish = dataDTO.titleEnglish();
        this.titleJapanese = dataDTO.titleJapanese();
        this.type = dataDTO.type();
        this.source = dataDTO.source();
        this.episodes = dataDTO.episodes();
        this.status = dataDTO.status();
        this.titles = new Titles(dataDTO.titles());
    }

    public Data(Data data) {
        this.id = data.getId();
        this.url = data.getUrl();
        this.title = data.getTitle();
        this.titleEnglish = data.getTitleEnglish();
        this.titleJapanese = data.getTitleJapanese();
        this.type = data.getType();
        this.source = data.getSource();
        this.episodes = data.getEpisodes();
        this.status = data.getStatus();
        this.images = data.getImages();
        this.titles = data.getTitles();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Data{" +
                "\tid=" + id + "\n" +
                "\turl='" + url + '\'' + "\n" +
                "\timages=" + images + "\n" +
                "\ttitle='" + title + '\'' + "\n" +
                "\ttitleEnglish='" + titleEnglish + '\'' + "\n" +
                "\ttitleJapanese='" + titleJapanese + '\'' + "\n" +
                "\ttype='" + type + '\'' + "\n" +
                "\tsource='" + source + '\'' + "\n" +
                "\tepisodes=" + episodes + "\n" +
                "\tstatus='" + status + '\'' + "\n" +
                "\ttitles=" + titles + "\n" +
                '}';
    }
}

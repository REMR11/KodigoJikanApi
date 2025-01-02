package org.kodigo.JikanAPIREST.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataDTO(
        @JsonAlias("url") String url,
        @JsonAlias("images") ImagesDTO images,
        @JsonAlias("title") String title,
        @JsonAlias("title_english") String titleEnglish,
        @JsonAlias("title_japanese") String titleJapanese,
        @JsonAlias("type") String type,
        @JsonAlias("source") String source,
        @JsonAlias("episodes") Integer episodes,
        @JsonAlias("status") String status,
        @JsonAlias("titles") List<TitleDTO> titles
) {}

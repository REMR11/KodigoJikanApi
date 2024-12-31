package org.kodigo.JikanAPIREST.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TitleDTO(
        @JsonAlias("type") String type,
        @JsonAlias("title") String title
) {}

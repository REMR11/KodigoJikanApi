package org.kodigo.JikanAPIREST.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TitlesDTO(
        @JsonAlias("titles") List<TitleDTO> titles
) {}

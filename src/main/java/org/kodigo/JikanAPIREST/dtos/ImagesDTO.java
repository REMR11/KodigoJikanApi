package org.kodigo.JikanAPIREST.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImagesDTO(
        @JsonAlias("webp") WebpDTO webp,
        @JsonAlias("jpg") JpgDTO jpg
) {}

package org.kodigo.JikanAPIREST.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebpDTO(
        @JsonAlias("image_url") String imageUrl,
        @JsonAlias("small_image_url") String smallImageUrl,
        @JsonAlias("large_image_url") String largeImageUrl
) {}

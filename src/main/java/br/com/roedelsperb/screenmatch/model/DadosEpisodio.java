package br.com.roedelsperb.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") Integer numEpisodio,
                            @JsonAlias("Season") Integer temporada,
                            @JsonAlias("Released") String data,
                            @JsonAlias("imdbRating") String avaliacao) {
}
